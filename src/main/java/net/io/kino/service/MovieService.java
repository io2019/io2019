package net.io.kino.service;

import net.io.kino.model.Movie;
import net.io.kino.model.MovieCategory;

import java.time.Duration;
import java.util.List;

public interface MovieService {
    Movie createMovie (Movie movie);
    void updateMovie(Movie movie);
    Movie getMovieById(long id);
    List<Movie> getMovieByTitle(String title);
    List<Movie> getMovies();
}
