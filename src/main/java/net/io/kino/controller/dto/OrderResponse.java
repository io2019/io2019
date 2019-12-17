package net.io.kino.controller.dto;

import net.io.kino.model.Order;

public class OrderResponse extends Order {
    private String redirectURL;
    private Long id;

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
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
