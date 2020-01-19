package net.io.kino.controller;

import net.io.kino.controller.dto.ShowroomRequest;
import net.io.kino.model.Showroom;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/showrooms")
public class ShowRoomController {

    // dummy methods because showrooms, tickets and showtimes modules are not ready yet
    @GetMapping
    public List<Showroom> getShowRooms() { return new ArrayList<>(); }

    @GetMapping("/{id}")
    public Showroom getShowRoom(@PathVariable Long id) { return new Showroom(); }

    @PostMapping("/")
    public Showroom addShowRoom(@RequestBody ShowroomRequest showroomRequest) {
        Showroom showroom = new Showroom();
        showroom.setName(showroomRequest.getName());
        // no methods...
        //showroom.setNoOfColumns(showroomRequest.getNoOfColumns());
        //showroom.setNoOfRows(showroomRequest.getNoOfRows());

        return showroom;
        }
    }

