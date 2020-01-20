package net.io.kino.controller.dto;

import net.io.kino.model.Movie;
import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;
import net.io.kino.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ShowtimeResponse {
    private Long id;
    private LocalDateTime date;
    private Movie movie;
    private Showroom showroom;
    private List<Integer> takenSeats;

    public static ShowtimeResponse of(Showtime showtime, List<Ticket> tickets) {
        ShowtimeResponse response = new ShowtimeResponse();
        response.id = showtime.getId();
        response.date = showtime.getDate();
        response.movie = showtime.getMovie();
        response.showroom = showtime.getShowroom();
        response.takenSeats = tickets.stream().map(ticket -> ticket.getSeatPosition()).collect(Collectors.toList());
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public List<Integer> getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(List<Integer> takenSeats) {
        this.takenSeats = takenSeats;
    }
}
