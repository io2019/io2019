package net.io.kino.service.impl;

import net.io.kino.model.Showroom;
import net.io.kino.repository.ShowroomRepository;
import net.io.kino.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowroomServiceImpl implements ShowroomService {

    @Autowired
    ShowroomRepository showrooms;

    @Override
    public Showroom createShowroom(Showroom showroom) { return showrooms.save(showroom); }

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
