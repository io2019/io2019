package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import sun.util.calendar.BaseCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.List;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Movie movie;
    private Showroom showroom;
    private Integer numberOfGuests;
    private List<Seat> seats;
    private BaseCalendar.Date date;
    private Time startHour;
    private Time finishHour;

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

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public BaseCalendar.Date getDate() {
        return date;
    }

    public void setDate(BaseCalendar.Date date) {
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
