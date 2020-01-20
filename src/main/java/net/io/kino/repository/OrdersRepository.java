package net.io.kino.repository;

import net.io.kino.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByDateBetween(LocalDateTime fromDate, LocalDateTime toDate);

//    @Query(nativeQuery = true, value = "select * " +
//            "from orders o " +
//            "where :showtimeId in (select t.showtime.id from o.tickets t)")
//    List<Order> findByShowtimeId(@Param("showtimeId") long showtimeId);
}
