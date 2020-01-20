package net.io.kino.service.impl;

import net.io.kino.model.Showroom;
import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.repository.ShowroomRepository;
import net.io.kino.service.ShowroomService;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowroomServiceImpl implements ShowroomService {

    @Autowired
    ShowroomRepository showrooms;

    @Qualifier("databaseLoggingOperationsImpl")
    @Autowired
    LoggingOperations loggingOperations;

    @Override
    public Showroom createShowroom(Showroom showroom) {
        loggingOperations.saveLog(new EventData("admin", EventType.SHOWROOM_ADDED));
        return showrooms.save(showroom);
    }

    @Override
    public void updateShowroom(Showroom showroom) {
        if(showrooms.findShowroomById(showroom.getId()) == null) {
            throw new IllegalArgumentException();
        } else {
            showrooms.save(showroom);
        }
    }

    @Override
    public Showroom getShowroomById(long id){
        return showrooms.findShowroomById(id);
    }

    @Override
    public Showroom getShowroomByName(String name) {
        return showrooms.findShowroomByName(name);
    }

    @Override
    public List<Showroom> getShowrooms() { return showrooms.findAll(); }
}
