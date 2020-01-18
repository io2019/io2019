package net.io.kino;

import net.io.kino.model.Manager;
import net.io.kino.model.TicketType;
import net.io.kino.repository.ManagersRepository;
import net.io.kino.repository.TicketTypesRepository;
import net.io.kino.service.impl.AuthenticationManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    private ManagersRepository managersRepository;

    @Autowired
    private TicketTypesRepository ticketTypesRepository;

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
    }

}
