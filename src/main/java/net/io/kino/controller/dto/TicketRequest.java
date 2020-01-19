package net.io.kino.controller.dto;

import net.io.kino.model.Showtime;
import net.io.kino.model.Ticket;
import net.io.kino.model.TicketType;

public class TicketRequest {
    private TicketType ticketType;
    private Integer seatPosition;
    private long showtimeId;

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Integer getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(Integer seatPosition) {
        this.seatPosition = seatPosition;
    }

    public long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Ticket convertToTicket(Showtime showtime) {
        Ticket t = new Ticket();
        t.setTicketType(ticketType);
        t.setSeatPosition(seatPosition);
        t.setShowtime(showtime);
        return t;
    }
}
