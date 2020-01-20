package net.io.kino.controller;

import net.io.kino.model.Showroom;
import net.io.kino.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping(params = "name")
    public Showroom getShowRoom(@RequestParam String name) {
        return showroomService.getShowroomByName(name);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Showroom addShowRoom(@RequestBody Showroom showroom) {
        showroomService.createShowroom(showroom);
        return showroom;
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HttpStatus> updateShowroom(@PathVariable Long id, @RequestBody Showroom showroom) {
        showroom.setId(id);
        try {
            showroomService.createShowroom(showroom);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

