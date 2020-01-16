package net.io.kino.service;

import net.io.kino.model.Showtime;

import java.util.Optional;

public interface ShowtimeService {
    Showtime findShowtimeById(long id);
}
