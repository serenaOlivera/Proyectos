package com.example.ticket_api.controller;

import com.example.ticket_api.model.TicketRequest;
import com.example.ticket_api.model.TicketResponse;
import com.example.ticket_api.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> create(@RequestBody TicketRequest request) {
        TicketResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}