package net.io.kino.controller;

import net.io.kino.controller.dto.MovieRequest;
import net.io.kino.model.Movie;
import net.io.kino.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() { return movieService.getMovies(); }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable long id) { return movieService.getMovieById(id); }

    @GetMapping("/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable String title) { return movieService.getMovieByTitle(title); }

    @PostMapping
    public Movie addMovie(@RequestBody MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setAgeRestriction(movieRequest.getAgeRestriction());
        movie.setCategory(movieRequest.getCategory());
        movie.setDescription(movieRequest.getDescription());
        movie.setDirector(movieRequest.getDirector());
        movie.setDuration(movieRequest.getDuration());
        movie.setTitle(movieRequest.getTitle());
        movieService.createMovie(movie);
        return movie;
    }
}
