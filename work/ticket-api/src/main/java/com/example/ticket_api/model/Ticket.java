package com.example.ticket_api.model;

import java.math.BigDecimal;

public record Ticket (
    Long id,
    String status,
    BigDecimal total
){
    // crea un ticket nuevo, recien abierto y todavia sin id
    public static Ticket open(BigDecimal total){
        return new Ticket(null, "OPEN", total);
    }

    //wither: devuelve una copia del ticket con el id puesto.
    // no modifica el original 
    public Ticket withId(long id){
        return new Ticket(id, this.status, this.total);
    }
}
