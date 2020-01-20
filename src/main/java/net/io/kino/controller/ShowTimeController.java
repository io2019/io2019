package net.io.kino.controller;

import net.io.kino.controller.dto.ShowtimeRequest;
import net.io.kino.model.Showtime;
import net.io.kino.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowTimeController {

    @Autowired
    ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getShowTimes() {
        return showtimeService.getAllShowtimes();
    }

    @GetMapping(params = {"startDate", "endDate", "showroomId"})
    public List<Showtime> getShowTimesByDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate, @RequestParam Long showroomId) {
        return showtimeService.getShowtimesByDateInShowroomBetween(startDate, endDate, showroomId);
    }

    @GetMapping("/{id}")
    public Showtime getShowTimeById(@PathVariable Long id) {
        return showtimeService.getShowtimeById(id);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Showtime addShowTime(@RequestBody ShowtimeRequest showtimeRequest) {
        Showtime showtime = new Showtime();
        showtime.setDate(showtimeRequest.getDate());
        showtime.setMovie(showtimeRequest.getMovie());
        showtime.setShowroom(showtimeRequest.getShowroom());
        showtimeService.createShowtime(showtime);
        return showtime;
    }

}
