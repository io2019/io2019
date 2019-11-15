package net.io.kino.service.impl;

import net.io.kino.model.Ticket;
import net.io.kino.repository.TicketRepository;
import net.io.kino.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository tickets;

    @Override
    public void confirmTicket(Ticket ticket) {
        ticket.setCokolwiek("abcd");
        tickets.save(ticket);
    }

}
