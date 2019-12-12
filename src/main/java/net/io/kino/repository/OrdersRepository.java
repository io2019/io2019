package net.io.kino.repository;

import net.io.kino.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long>{ }
