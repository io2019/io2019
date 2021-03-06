package net.io.kino.service;

import net.io.kino.model.Showroom;

import java.util.List;

public interface ShowroomService {
    Showroom createShowroom(Showroom showroom);
    void updateShowroom(Showroom showroom);
    Showroom getShowroomById(long id);
    Showroom getShowroomByName(String name);
    List<Showroom> getShowrooms();
}
