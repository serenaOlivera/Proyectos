package com.example.ticket_api.model;

import java.math.BigDecimal;

public record Ticket (
    Long id,
    String status,
    BigDecimal total
){}
