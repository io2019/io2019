package net.io.kino.repository;

import net.io.kino.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypesRepository extends JpaRepository<TicketType, Long>{ }
