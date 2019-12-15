package net.io.kino.repository;

import net.io.kino.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findAllInShowroom(String showroom);
}
