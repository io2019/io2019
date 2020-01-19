package net.io.kino.service.impl;

import net.io.kino.model.Movie;
import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;
import net.io.kino.repository.ShowtimeRepository;
import net.io.kino.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShowtimeServiceImpl implements ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Override
    public Showtime createShowtime(Showtime showtime) {
        if (showtimeRepository.findShowtimesByDateBetween(showtime.getDate(), showtime.getFinishHour(), showtime.getShowroom().getId()).size() != 0) {
            throw new IllegalArgumentException("This showtime overlaps with another showtime.");
        }

        return showtimeRepository.save(showtime);
    }

    @Override
    public void updateShowtime(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    public Showtime getShowtimeById(long id) {
        return showtimeRepository.findShowtimeById(id);
    }

    @Override
    public List<Showtime> getShowtimesByShowroom(Showroom showroom) {
        return showtimeRepository.findShowtimesByShowroom(showroom);
    }

    @Override
    public List<Showtime> getShowtimesByMovie(Movie movie) {
        return showtimeRepository.findShowtimesByMovie(movie);
    }

}