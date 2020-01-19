package net.io.kino.repository;

import net.io.kino.model.Movie;
import net.io.kino.model.Showroom;
import net.io.kino.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    Showtime findShowtimeById(Long id);
    List<Showtime> findShowtimesByShowroom(Showroom showroom);
    List<Showtime> findShowtimesByMovie(Movie movie);
    List<Showtime> findAll();
    @Query(nativeQuery = true, value = "select st.id, date, movie_id, showroom_id " +
            "from showtimes st " +
            "left join movies m on st.movie_id = m.id " +
            "where date <= :endDate " +
            "  and DATEADD(MINUTE, duration, date) >= :startDate" +
            "  and showroom_id = :showroomId")
    List<Showtime> findShowtimesByDateInShowroomBetween(@Param("startDate") LocalDateTime startDate,
                                              @Param("endDate") LocalDateTime endDate,
                                              @Param("showroomId") long showroomId);

    @Query(nativeQuery = true, value = "select st.id, date, movie_id, showroom_id " +
            "from showtimes st " +
            "left join movies m on st.movie_id = m.id " +
            "where date <= :endDate " +
            "  and DATEADD(MINUTE, duration, date) >= :startDate")
    List<Showtime> findShowtimesByDateBetween(@Param("startDate") LocalDateTime startDate,
                                              @Param("endDate") LocalDateTime endDate);

}