package com.example.appvotemicroservice.service;

import com.example.appvotemicroservice.exception.ModelNotFoundException;
import com.example.appvotemicroservice.model.entity.TankEntity;
import com.example.appvotemicroservice.repository.TanksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TankService {

    private final TanksRepository tanksRepository;

    public Page<TankEntity> getTanks(Pageable pageable) {
        return tanksRepository.findAll(pageable);
    }

    public TankEntity getTankById(UUID id) {
        return tanksRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(TankEntity.class, id));
    }
}