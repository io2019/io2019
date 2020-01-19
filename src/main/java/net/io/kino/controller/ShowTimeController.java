package net.io.kino.controller;

import net.io.kino.controller.dto.ShowtimeRequest;
import net.io.kino.model.Movie;
import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;
import net.io.kino.repository.ShowroomRepository;
import net.io.kino.repository.ShowtimeRepository;
import net.io.kino.service.ShowroomService;
import net.io.kino.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowTimeController {

    ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getShowTimes() {
        return showtimeService.getAllShowtimes();
    }

    @GetMapping(params = {"startDate", "endDate", "showroomId"})
    public List<Showtime> getShowTimesByDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return showtimeService.getShowtimesByDateBetween(startDate, endDate);
    }

    @GetMapping("/{id}")
    public Showtime getShowTimeById(@PathVariable Long id) {
        return showtimeService.getShowtimeById(id);
    }

    @PostMapping
    public Showtime addShowTime(@RequestBody ShowtimeRequest showtimeRequest) {
        Showtime showtime = new Showtime();
        showtime.setDate(showtimeRequest.getDate());
        showtime.setMovie(showtimeRequest.getMovie());
        showtime.setShowroom(showtimeRequest.getShowroom());
        showtimeService.createShowtime(showtime);
        return showtime;
    }

}
