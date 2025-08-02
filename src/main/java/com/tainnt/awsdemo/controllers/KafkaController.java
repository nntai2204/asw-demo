package com.tainnt.awsdemo.controllers;

import com.tainnt.awsdemo.sevices.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        producerService.sendMessage("test-topic", message);
        return ResponseEntity.ok("Sent: " + message);
    }
}

