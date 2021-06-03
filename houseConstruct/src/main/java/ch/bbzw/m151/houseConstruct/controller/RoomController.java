package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/room")
public class RoomController {

    @GetMapping("/")
    public List<Room> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Room> get(@PathVariable long id) {
        return null;
    }

    @PostMapping("/")
    public Room add(@RequestBody Room r) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}