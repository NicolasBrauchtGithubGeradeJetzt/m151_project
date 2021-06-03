package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Building;
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

    @PostMapping("/")
    public Building add(@RequestBody Building b) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}