package com.example.ticket_api;

import com.example.ticket_api.model.Ticket;
import com.example.ticket_api.repository.TicketRepository;
import com.example.ticket_api.model.TicketRequest;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository){
        this.repository= repository;
    }

    public Ticket create(TicketRequest request){
        if (request.total().signum()<= 0){
            throw new IllegalArgumentException("total must be positive");
        }
        return repository.save(Ticket.open(request.total()));
    }
}
