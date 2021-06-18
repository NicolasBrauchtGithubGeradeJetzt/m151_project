package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Furniture;
import ch.bbzw.m151.houseConstruct.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureController(final FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public List<Furniture> getAll() {
        return furnitureService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Furniture> get(@PathVariable long id) {
        return furnitureService.get(id);
    }

    @PostMapping("/")
    public Furniture add(@RequestBody Furniture f) {
        return furnitureService.add(f);
    }

    @PutMapping("/")
    public Furniture change(@RequestBody Furniture r) {
        return furnitureService.update(r).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        furnitureService.delete(id);
    }
}