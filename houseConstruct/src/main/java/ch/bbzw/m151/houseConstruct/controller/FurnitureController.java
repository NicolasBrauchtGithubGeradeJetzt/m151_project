package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fruits")
public class FurnitureController {

    @GetMapping("/")
    public List<Furniture> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Furniture> get(@PathVariable long id) {
        return null;
    }

    @PostMapping("/")
    public Furniture add(@RequestBody Furniture f) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}