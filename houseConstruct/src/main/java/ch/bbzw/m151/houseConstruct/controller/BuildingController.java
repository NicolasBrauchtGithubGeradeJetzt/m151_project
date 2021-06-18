package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.Building;
import ch.bbzw.m151.houseConstruct.model.Floor;
import ch.bbzw.m151.houseConstruct.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/building")
@PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt')")
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired
    public BuildingController(final BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public List<Building> getAll() {
        return buildingService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public Optional<Building> get(@PathVariable long id) {
        return buildingService.get(id);
    }

    @GetMapping("/floor/{building_id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public Optional<Floor> getAllFloor(@PathVariable long building_id) {
        return null;
    }

    @GetMapping("/blueprint/{building_id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Architekt') or hasAuthority('Kunde')")
    public String getBlueprint(@PathVariable long building_id) {
        return null;
    }

    @PostMapping("/")
    public Building add(@RequestBody Building b) {
        return buildingService.add(b);
    }

    @PutMapping("/")
    public Building change(@RequestBody Building b) {
        return buildingService.update(b).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        buildingService.delete(id);
    }
}