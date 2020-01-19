package net.io.kino.controller;

import net.io.kino.controller.dto.ShowtimeRequest;
import net.io.kino.model.Showtime;
import net.io.kino.service.ShowtimeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowTimeController {

    ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getShowTimes(@RequestParam LocalDate day) {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Showtime getShowTime(@PathVariable Long id) {
        return new Showtime();
    }

    @PostMapping("/")
    public Showtime addShowTime(@RequestBody ShowtimeRequest showtimeRequest) {
        Showtime showtime = new Showtime();
        showtime.setDate(showtimeRequest.getDate());
        showtime.setMovie(showtimeRequest.getMovie());
        showtime.setShowroom(showtimeRequest.getShowroom());
        //TODO: Get movies and showrooms from service
        //showtimeService. ups tu nic nie ma xD
        return showtime;
    }

    //@Autowired
    public void setShowtimeService(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }
}
