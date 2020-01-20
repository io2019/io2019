package net.io.kino.service.impl;

import net.io.kino.model.Movie;
import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.repository.MovieRepository;
import net.io.kino.service.MovieService;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movies;

    @Qualifier("databaseLoggingOperationsImpl")
    @Autowired
    LoggingOperations loggingOperations;

    @Override
    public Movie createMovie(Movie movie) {
        List<Movie> existingMovies = movies.findMovieByTitle(movie.getTitle());
        if (existingMovies.size() > 0) {
            throw new IllegalArgumentException("This movie already exists in repository.");
        }
        loggingOperations.saveLog(new EventData("admin", EventType.MOVIE_ADDED));
        return movies.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        if(movies.findMovieById(movie.getId()) == null) {
            throw new IllegalArgumentException();
        } else {
            loggingOperations.saveLog(new EventData("admin", EventType.MOVIE_UPDATED));
            movies.save(movie);
        }
    }

    @Override
    public Movie getMovieById(long id) { return movies.findMovieById(id); }

    @Override
    public List<Movie> getMovieByTitle(String title) { return movies.findMovieByTitle(title); }

    @Override
    public List<Movie> getMovies() { return movies.findAll(); }
}
