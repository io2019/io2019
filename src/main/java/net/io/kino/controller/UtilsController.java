package net.io.kino.controller;

import net.io.kino.model.TicketType;
import net.io.kino.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UtilsController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/ticketTypes")
    public List<TicketType> getTicketTypes() {
        return reservationService.getTicketTypes();
    }
}
