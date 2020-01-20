package net.io.kino.controller;

import net.io.kino.controller.dto.ShowtimeRequest;
import net.io.kino.controller.dto.ShowtimeResponse;
import net.io.kino.model.Showtime;
import net.io.kino.service.MovieService;
import net.io.kino.service.ReservationService;
import net.io.kino.service.ShowroomService;
import net.io.kino.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/showtimes")
public class ShowTimeController {

    @Autowired
    ShowtimeService showtimeService;
    @Autowired
    MovieService movieService;
    @Autowired
    ShowroomService showroomService;
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<Showtime> getShowTimes() {
        return showtimeService.getAllShowtimes();
    }

    @GetMapping(params = {"startDate", "endDate"})
    public List<Showtime> getShowTimesByDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate, @RequestParam(value = "showroomId", required = false) Long showroomId) {
        if(showroomId == null)
            return showtimeService.getShowtimesBetweenDates(startDate, endDate);
        else
            return showtimeService.getShowtimesByDateInShowroomBetween(startDate, endDate, showroomId);
    }

    @GetMapping("/{id}")
    public ShowtimeResponse getShowTimeById(@PathVariable Long id) {
        return ShowtimeResponse.of(showtimeService.getShowtimeById(id),
                reservationService.getTicketsByShowtime(id));
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Showtime addShowTime(@RequestBody ShowtimeRequest showtimeRequest) {
        Showtime showtime = new Showtime();
        showtime.setDate(showtimeRequest.getDateTime());
        showtime.setMovie(movieService.getMovieById(showtimeRequest.getMovieId()));
        showtime.setShowroom(showroomService.getShowroomById(showtimeRequest.getShowroomId()));
        return showtimeService.createShowtime(showtime);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HttpStatus> updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        showtime.setId(id);
        try {
            showtimeService.updateShowtime(showtime);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
