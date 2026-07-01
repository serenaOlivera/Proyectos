package com.example.ticket_api.repository;

import com.example.ticket_api.model.Ticket;
import java.util.Optional;

// esta es la interfaz, es como el .h de c :)
public interface TicketRepository {
    Ticket save(Ticket ticket);

    Optional<Ticket> findById(Long id);
}
