package net.io.kino.controller;

import net.io.kino.controller.dto.ShowroomRequest;
import net.io.kino.model.Showroom;
import net.io.kino.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showrooms")
public class ShowRoomController {

    @Autowired
    ShowroomService showroomService;

    @GetMapping
    public List<Showroom> getShowRooms() {
        return showroomService.getShowrooms();
    }

    @GetMapping("/{id}")
    public Showroom getShowRoom(@PathVariable Long id) {
        return showroomService.getShowroomById(id);
    }

    @GetMapping("/{name}")
    public Showroom getShowRoom(@PathVariable String name) {
        return showroomService.getShowroomByName(name);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Showroom addShowRoom(@RequestBody ShowroomRequest showroomRequest) {
        Showroom showroom = new Showroom();
        showroom.setName(showroomRequest.getName());
        showroom.setNoOfColumns(showroomRequest.getNoOfColumns());
        showroom.setNoOfRows(showroomRequest.getNoOfRows());
        showroomService.createShowroom(showroom);
        return showroom;
    }
}

