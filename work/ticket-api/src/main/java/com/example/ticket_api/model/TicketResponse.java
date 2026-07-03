package com.example.ticket_api.model;

import java.math.BigDecimal;

/* lo que se devuelve una vez que creamos el ticket
   que sea igual a Ticket, no implica que tengan las mismas incumbencias
*/
public record TicketResponse (
    Long id, 
    String status,
    BigDecimal total
){}
