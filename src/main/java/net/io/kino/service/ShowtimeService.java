package net.io.kino.service;

import net.io.kino.model.Order;

import java.util.Optional;

public interface ShowtimeService {
    Optional<Order> findShowtimeById(long id);
}
