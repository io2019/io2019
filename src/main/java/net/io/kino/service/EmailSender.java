package net.io.kino.service;

import net.io.kino.model.Order;

public interface EmailSender {
    void sendEmail(String to, Order order);
}
