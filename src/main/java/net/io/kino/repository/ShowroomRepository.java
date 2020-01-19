package net.io.kino.repository;

import net.io.kino.model.Showroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowroomRepository extends JpaRepository<Showroom, Long> {

    Showroom findShowroomById(Long id);
    Showroom findShowroomByName(String name);
    List<Showroom> findAll();
}