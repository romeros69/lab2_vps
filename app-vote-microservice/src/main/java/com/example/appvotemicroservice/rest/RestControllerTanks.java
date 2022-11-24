package com.example.appvotemicroservice.rest;

import com.example.appvotemicroservice.model.dto.PageResponse;
import com.example.appvotemicroservice.model.dto.TankMapper;
import com.example.appvotemicroservice.service.TankService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tanks")
@RequiredArgsConstructor
public class RestControllerTanks {

    private static final String HEADER_TOTAL_COUNT = "Total-Count";

    private final TankService tankService;

    private final TankMapper tankMapper;

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault Pageable pageable) {
        var tanksPage = tankService.getTanks(pageable);
        var tankDTOList = tanksPage
                .stream()
                .map(tankMapper::tankEntityToTankDTO)
                .collect(Collectors.toList());
        var bodyBuilder = tanksPage.hasNext() || tanksPage.hasPrevious()
                ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                : ResponseEntity.ok();
        return bodyBuilder
                .header(HEADER_TOTAL_COUNT, String.valueOf(tanksPage.getTotalElements()))
                .body(PageResponse
                        .builder(tankDTOList)
                        .build()
                );
    }
}
