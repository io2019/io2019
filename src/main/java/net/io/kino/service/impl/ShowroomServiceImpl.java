package net.io.kino.service.impl;

import net.io.kino.model.Showroom;
import net.io.kino.repository.ShowroomRepository;
import net.io.kino.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShowroomServiceImpl implements ShowroomService {

    @Autowired
    ShowroomRepository showrooms;

    @Override
    public Showroom createShowroom(Showroom showroom) { return showrooms.save(showroom); }

    @Override
    public void updateShowroomById(long id, String name){
        Showroom showroom = getShowroomById(id);
        if (name != null) {
            showroom.setName(name);
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