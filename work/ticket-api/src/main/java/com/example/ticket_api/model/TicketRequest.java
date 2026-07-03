package com.example.ticket_api.model;

import java.math.BigDecimal;

// este es el ticket del cliente, solo tiene el importe
public record TicketRequest(
    BigDecimal total
) {} 
    