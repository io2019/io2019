package net.io.kino.controller.dto;

import net.io.kino.model.OrderState;

public class OrderVerifyResponse {

    private String transactionId;
    private OrderState state;

    public OrderVerifyResponse(String transactionId, OrderState state) {
        this.transactionId = transactionId;
        this.state = state;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

}
