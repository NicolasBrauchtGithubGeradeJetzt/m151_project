package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Floor;
import ch.bbzw.m151.houseConstruct.model.Room;
import ch.bbzw.m151.houseConstruct.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/floor")
@PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt')")
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(final FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public List<Floor> getAll() {
        return floorService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public Optional<Floor> get(@PathVariable long id) {
        return floorService.get(id);
    }

    @GetMapping("/rooms/{floor_id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public Optional<Room> getAllRoom(@PathVariable long floor_id) {
        return null;
    }

    @PostMapping("/")
    public Floor add(@RequestBody Floor f) {
        return floorService.add(f);
    }

    @PutMapping("/")
    public Floor change(@RequestBody Floor f) {
        return floorService.update(f).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        floorService.delete(id);
    }
}