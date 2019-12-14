package net.io.kino.repository;

import net.io.kino.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // Spring generuje zapytania do bazy na podstawie nazwy metody
//    List<Ticket> findTicketByCokolwiek(String cokolwiek);

}
