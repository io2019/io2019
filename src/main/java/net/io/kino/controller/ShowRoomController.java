package net.io.kino.controller;

import net.io.kino.controller.dto.ShowroomRequest;
import net.io.kino.model.Showroom;
import net.io.kino.repository.LogRepository;
import net.io.kino.repository.ShowroomRepository;
import net.io.kino.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/showrooms")
public class ShowRoomController {

    @Autowired
    ShowroomRepository showroomRepository;
    ShowroomService showroomService;

    @GetMapping
    public List<Showroom> getShowRooms() { return showroomRepository.findAll(); }

    @GetMapping("/{id}")
    public Showroom getShowRoom(@PathVariable Long id) { return showroomRepository.findShowroomById(id); }

    @GetMapping(params = "name")
    public Showroom getShowRoom(@RequestParam String name) { return showroomRepository.findShowroomByName(name); }

    @PostMapping
    public Showroom addShowRoom(@RequestBody ShowroomRequest showroomRequest) {
        Showroom showroom = new Showroom();
        showroom.setName(showroomRequest.getName());
        showroom.setNoOfColumns(showroomRequest.getNoOfColumns());
        showroom.setNoOfRows(showroomRequest.getNoOfRows());
        showroomService.createShowroom(showroom);
        return showroom;
        }
    }

