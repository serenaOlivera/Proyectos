package com.example.ticket_api.service;

import com.example.ticket_api.model.Ticket;
import com.example.ticket_api.model.TicketResponse;
import com.example.ticket_api.repository.TicketRepository;
import com.example.ticket_api.model.TicketRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository){
        this.repository= repository;
    }

    public TicketResponse create(TicketRequest request){
        if (request.total() == null 
            || request.total().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El total debe ser mayor a cero");
        }

        Ticket nuevo = Ticket.open(request.total());
        Ticket guardado = repository.save(nuevo);
        return toResponse(guardado);
    }

    private TicketResponse toResponse(Ticket ticket){
        return new TicketResponse(
            ticket.id(),
            ticket.status(),
            ticket.total()
        );
    }
}
