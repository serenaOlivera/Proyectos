package com.example.ticket_api.repository;

import com.example.ticket_api.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTicketRepository implements TicketRepository {
    
    private final Map<Long, Ticket> data = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @Override
    public Ticket save(Ticket ticket){
        Long id = ids.incrementAndGet();
        Ticket saved = ticket.withId(id);
        data.put(id, saved) ;
        return saved;
    }

    @Override
    public Optional<Ticket> findById(Long id){
        return Optional.ofNullable(data.get(id));
    }
}
