package net.io.kino.controller.dto;
import net.io.kino.model.Showtime;
import net.io.kino.model.Ticket;
import net.io.kino.model.TicketType;

public class TicketRequest {
    private TicketType ticketType;
    private Integer seatPosition;

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

    public Ticket convertToTicket(Showtime showtime) {
        Ticket t = new Ticket();
        t.setTicketType(ticketType);
        t.setSeatPosition(seatPosition);
        t.setShowTime(showtime);
        return  t;
    }
}
