package net.io.kino.repository;

import net.io.kino.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> getSeatById(Long id);

}
