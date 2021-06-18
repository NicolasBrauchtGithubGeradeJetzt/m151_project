package ch.bbzw.m151.houseConstruct.service;

import ch.bbzw.m151.houseConstruct.model.Building;
import ch.bbzw.m151.houseConstruct.repo.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = {"building"})
public class BuildingService {

    private final BuildingRepo buildingRepo;

    @Autowired
    public BuildingService(final BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "0")
    public List<Building> getAll() {
        final Iterable<Building> building = buildingRepo.findAll();
        return StreamSupport
                .stream(building.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "#id", unless = "#result == null")
    public Optional<Building> get(final long id) {
       return Optional.ofNullable(buildingRepo.findById(id));
    }

    @Transactional
    @CachePut(key = "#user.id")
    @CacheEvict(key = "0")
    public Building add(final Building building) {
        return buildingRepo.save(building);
    }

    @Transactional
    public Optional<Building> update(final Building building) {
        final Optional<Building> optionalBuilding = this.get(building.getId());
        if (optionalBuilding.isPresent()) {
            return Optional.of(buildingRepo.save(building));
        }
        return Optional.empty();
    }

    @Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "0")})
    public void delete(final long id) {
        buildingRepo.deleteById(id);
    }
}