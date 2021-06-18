package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Room;
import ch.bbzw.m151.houseConstruct.service.RoomService;
import ch.bbzw.m151.houseConstruct.model.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/room")
@PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt')")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(final RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public Optional<Room> get(@PathVariable long id) {
        return roomService.get(id);
    }

    @GetMapping("/furniture/{room_id}")
    public Optional<Furniture> getAllFurniture(@PathVariable long room_id) {
        return null;
    }

    @PostMapping("/")
    public Room add(@RequestBody Room r) {
        return roomService.add(r);
    }

    @PostMapping("/{room_id}/addFurniture/{furniture_id}")
    public Room addFurniture(@PathVariable("room_id") long room_id, @PathVariable("furniture_id") long furniture_id) {
        return null;
    }
    
    @PutMapping("/")
    public Room change(@RequestBody Room r) {
        return roomService.update(r).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        roomService.delete(id);
    }
}