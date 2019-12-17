package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Movie movie;
    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Showroom showroom;

    private LocalDateTime date;

    public Showtime() {}

    public Showtime(Movie movie, Showroom showroom, LocalDateTime date, Time startHour, Time finishHour) {
        this.movie = movie;
        this.showroom = showroom;
        this.date = date;
    }

    public long getId() {
        return id;
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
        return date.plusMinutes(movie.getDuration().toMinutes());
    }

}