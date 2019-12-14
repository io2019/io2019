package net.io.kino.controller;

import net.io.kino.model.Seat;
import net.io.kino.model.Ticket;
import net.io.kino.repository.SeatRepository;
import net.io.kino.repository.TicketRepository;
import net.io.kino.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/tickets")
public class TestController {

    @Autowired
    private TicketRepository tickets;

    @Autowired
    private SeatRepository seats;

    @Autowired
    private TicketService ticketService;

    private final Random random = new Random();

    @GetMapping
    public List<Ticket> all() {
        return tickets.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ticket> get(@PathVariable long id) {
        return tickets.findById(id);
    }

    @PatchMapping("/{id}")
    public Optional<Ticket> confirm(@PathVariable long id) {
        Optional<Ticket> ticket = tickets.findById(id);
        ticket.ifPresent(value -> ticketService.confirmTicket(value));
        return ticket;
    }

    @PostMapping
    public Ticket add() {
        Seat seat = new Seat(random.nextInt());
        seats.save(seat);

        Ticket ticket = new Ticket();
        tickets.save(ticket);

        return ticket;
    }

//    @GetMapping("/xd/{cokolwiek}")
//    public List<Ticket> get(@PathVariable String cokolwiek) {
//        return tickets.findTicketByCokolwiek(cokolwiek);
//    }

}
