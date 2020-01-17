package net.io.kino.controller;

import net.io.kino.model.TicketType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UtilsController {
    @GetMapping("/ticketTypes")
    public List<TicketType> getTicketTypes() {
        return new ArrayList<>();
    }
}
