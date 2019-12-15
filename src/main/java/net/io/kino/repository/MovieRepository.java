package net.io.kino.repository;

import net.io.kino.model.Movie;
import net.io.kino.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> getMovieById(Long id);
    List<Movie> getMoviesByDirector(String director);
    List<Movie> getMovieByTitle(String title);

}

