package net.io.kino.controller.dto;

import net.io.kino.model.Order;

public class OrderResponse extends Order {
    private String redirecrURL;
    private Long id;

    public String getRedirecrURL() {
        return redirecrURL;
    }

    public void setRedirecrURL(String redirecrURL) {
        this.redirecrURL = redirecrURL;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void fillProperties(Order order) {
        this.setId(order.getId());
        this.setTickets(order.getTickets());
        this.setClient(order.getClient());
        this.setState(order.getState());

    }
}
