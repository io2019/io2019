package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "showtimes")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Movie movie;
    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Showroom showroom;

    private LocalDateTime date;

    public Showtime() {}

    public Showtime(Movie movie, Showroom showroom, LocalDateTime date) {
        this.movie = movie;
        this.showroom = showroom;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getFinishHour() {
        return date.plusMinutes(movie.getDuration());
    }

}
