package com.example.ticket_api.model;

import java.math.BigDecimal;

public record TicketResponse (
    Long id, 
    String status,
    BigDecimal total
){}
