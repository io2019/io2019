package net.io.kino.repository;

import net.io.kino.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
}
