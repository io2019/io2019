package net.io.kino.repository;

import net.io.kino.model.Movie;
import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> getShowtimeById(Long id);
    List<Showtime> getShowtimesByShowroom(Showroom showroom);
    List<Showtime> getShowtimesByMovie(Movie movie);
    List<Showtime> getShowtimesByMovie_Title(String title);

}
