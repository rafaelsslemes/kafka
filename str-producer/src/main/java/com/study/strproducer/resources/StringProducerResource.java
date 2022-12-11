package com.study.strproducer.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.strproducer.service.StringProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class StringProducerResource {

    private final StringProducerService producerService;
    
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        producerService.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
