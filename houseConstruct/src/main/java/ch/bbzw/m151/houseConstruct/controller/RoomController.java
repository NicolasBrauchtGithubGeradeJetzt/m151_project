package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Room;
import ch.bbzw.m151.houseConstruct.model.Furniture;
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

    @GetMapping("/furniture/{room_id}")
    public Optional<Furniture> getAllFurniture(@PathVariable long room_id) {
        return null;
    }

    @PostMapping("/")
    public Room add(@RequestBody Room r) {
        return null;
    }

    @PostMapping("/{room_id}/addFurniture/{furniture_id}")
    public Room addFurniture(@PathVariable("room_id") long room_id, @PathVariable("furniture_id") long furniture_id) {
        return null;
    }
    
    @PostMapping("/set/{id}")
    public Room change(@RequestBody Room r, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}