package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Building;
import ch.bbzw.m151.houseConstruct.model.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/building")
public class BuildingController {

    @GetMapping("/")
    public List<Building> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Building> get(@PathVariable long id) {
        return null;
    }

    @GetMapping("/floor/{building_id}")
    public Optional<Floor> getAllFloor(@PathVariable long building_id) {
        return null;
    }

    @GetMapping("/blueprint/{building_id}")
    public String getBlueprint(@PathVariable long building_id) {
        return null;
    }

    @PostMapping("/")
    public Building add(@RequestBody Building b) {
        return null;
    }

    @PostMapping("/set/{id}")
    public Building change(@RequestBody Building b, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}