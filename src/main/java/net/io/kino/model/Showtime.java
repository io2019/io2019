package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


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

    private Date date;
    private Time startHour;
    private Time finishHour;

    public Showtime(){}

    public Showtime(Movie movie, Showroom showroom, Date date, Time startHour, Time finishHour) {
        this.movie = movie;
        this.showroom = showroom;
        this.date = date;
        this.startHour = startHour;
        this.finishHour = finishHour;
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

    public Showroom getShowroom() { return showroom; }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(Time finishHour) {
        this.finishHour = finishHour;
    }

}
