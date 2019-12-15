package net.io.kino.repository;

import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowroomRepository extends JpaRepository<Showroom, Long> {

    List<Showroom> getShowroomById(Long id);
    List<Showroom> getShowroomByName(String name);
}
