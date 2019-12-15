package net.io.kino.controller;

import net.io.kino.model.Showtime;
import net.io.kino.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class ShowtimeController {

    @Autowired
    private ShowtimeRepository showtimes;

    @GetMapping
    public List<Showtime> all() {return showtimes.findAll();}

    @GetMapping("/{id}")
    public Optional<Showtime> get (@PathVariable long id) { return showtimes.findById(id); }

}
