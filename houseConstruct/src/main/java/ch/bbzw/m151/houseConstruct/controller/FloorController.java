package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/floor")
public class FloorController {

    @GetMapping("/")
    public List<Floor> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Floor> get(@PathVariable long id) {
        return null;
    }

    @PostMapping("/")
    public Floor add(@RequestBody Floor f) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}