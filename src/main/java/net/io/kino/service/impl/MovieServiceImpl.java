package net.io.kino.service.impl;

import net.io.kino.model.Movie;
import net.io.kino.model.MovieCategory;
import net.io.kino.repository.MovieRepository;
import net.io.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movies;

    @Override
    public Movie createMovie(Movie movie) {
        List<Movie> existingMovies = movies.findMovieByTitle(movie.getTitle());
        if (existingMovies.size() > 0) {
            throw new IllegalArgumentException("This movie already exists in repository.");
        }
        return movies.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movies.save(movie);
    }

    @Override
    public Movie getMovieById(long id) { return movies.findMovieById(id); }

    @Override
    public List<Movie> getMovieByTitle(String title) { return movies.findMovieByTitle(title); }

    @Override
    public List<Movie> getMovies() { return movies.findAll(); }
}
