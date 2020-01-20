package net.io.kino.controller;

import net.io.kino.model.Movie;
import net.io.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/movies")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateMove(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        try {
            movieService.updateMovie(movie);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
