package com.example.ticket_api;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello (){
        return "Spring Boot funciona";
    }

    public record TicketResponse(
        Long id,
        String status, 
        java.math.BigDecimal total
    ){}

    @GetMapping("/tickets/{id}")
    public TicketResponse getTicket(@PathVariable Long id){
        return new TicketResponse(id, "OPEN",
            new BigDecimal("123.45"));
    }

}