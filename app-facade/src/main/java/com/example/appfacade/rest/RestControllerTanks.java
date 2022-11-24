package com.example.appfacade.rest;

import com.example.appfacade.rest.clients.VoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tanki")
public class RestControllerTanks {

    @Autowired
    private VoteClient voteClient;

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault Pageable pageable) {
        return voteClient.findAll(pageable);
    }
}
