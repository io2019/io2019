package net.io.kino.controller.dto;

import net.io.kino.model.PersonalDetails;
import java.util.List;

public class OrderRequest {
    private List<TicketRequest> tickets;
    private PersonalDetails client;

    public List<TicketRequest> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketRequest> tickets) {
        this.tickets = tickets;
    }

    public PersonalDetails getClient() {
        return client;
    }

    public void setClient(PersonalDetails client) {
        this.client = client;
    }
}
