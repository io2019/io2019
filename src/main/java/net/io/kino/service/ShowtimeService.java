package net.io.kino.service;

import net.io.kino.model.Movie;
import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowtimeService {
    Showtime createShowtime(Showtime showtime);
    void updateShowtime(Showtime showtime);
    Showtime getShowtimeById(long id);
    List<Showtime> getAllShowtimes();
    List<Showtime> getShowtimesByShowroom(Showroom showroom);
    List<Showtime> getShowtimesByMovie(Movie movie);
}
