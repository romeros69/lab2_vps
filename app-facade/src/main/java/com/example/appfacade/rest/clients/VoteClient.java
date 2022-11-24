package com.example.appfacade.rest.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "voteClient", url = "http://localhost:8085/api/v1/tanks")
public interface VoteClient {

    @GetMapping
    ResponseEntity<?> findAll(@PageableDefault Pageable pageable);
}
