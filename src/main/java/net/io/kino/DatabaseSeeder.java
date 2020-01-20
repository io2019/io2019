package net.io.kino;

import net.io.kino.model.*;
import net.io.kino.repository.*;
import net.io.kino.service.impl.AuthenticationManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class DatabaseSeeder {

    @Autowired
    private ManagersRepository managersRepository;

    @Autowired
    private TicketTypesRepository ticketTypesRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowroomRepository showroomRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        if (managersRepository.findAll().isEmpty()) {
            Manager manager = new Manager();
            manager.setUsername("admin");
            manager.setPassword(AuthenticationManagerImpl.getSaltedHash("dupa"));
            managersRepository.save(manager);
        }

        if (ticketTypesRepository.findAll().isEmpty()) {
            TicketType normalTicket = new TicketType("Normal", 26, true);
            ticketTypesRepository.save(normalTicket);

            TicketType reducedTicket = new TicketType("Reduced", 21, true);
            ticketTypesRepository.save(reducedTicket);
        }

        if (movieRepository.findAll().isEmpty()) {
            Movie movie = new Movie();
            movie.setTitle("Królewna śnieżka");
            movie.setDuration(120);
            movie.setAgeRestriction(12);
            movie.setDescription("Jakiś film");
            movie.setCategory(MovieCategory.Action);
            movieRepository.save(movie);
        }

        if (showroomRepository.findAll().isEmpty()) {
            Showroom showroom = new Showroom();
            showroom.setName("Magiczna");
            showroom.setNoOfColumns(10);
            showroom.setNoOfRows(10);
            showroomRepository.save(showroom);
        }

        if (showtimeRepository.findAll().isEmpty()) {
            Showtime showtime = new Showtime();
            showtime.setMovie(movieRepository.findAll().get(0));
            showtime.setShowroom(showroomRepository.findAll().get(0));
            showtime.setDate(LocalDateTime.now());
            showtimeRepository.save(showtime);
        }
    }

}
