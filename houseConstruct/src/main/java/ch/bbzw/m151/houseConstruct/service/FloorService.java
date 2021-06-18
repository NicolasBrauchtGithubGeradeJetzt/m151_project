package ch.bbzw.m151.houseConstruct.service;

import ch.bbzw.m151.houseConstruct.model.Floor;
import ch.bbzw.m151.houseConstruct.repo.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = {"floor"})
public class FloorService {

    private final FloorRepo floorRepo;

    @Autowired
    public FloorService(final FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "0")
    public List<Floor> getAll() {
        final Iterable<Floor> floor = floorRepo.findAll();
        return StreamSupport
                .stream(floor.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "#id", unless = "#result == null")
    public Optional<Floor> get(final long id) {
       return Optional.ofNullable(floorRepo.findById(id));
    }

    @Transactional
    @CachePut(key = "#floor.id")
    @CacheEvict(key = "0")
    public Floor add(final Floor floor) {
        return floorRepo.save(floor);
    }

    @Transactional
    public Optional<Floor> update(final Floor floor) {
        final Optional<Floor> optionalFloor = this.get(floor.getId());
        if (optionalFloor.isPresent()) {
            return Optional.of(floorRepo.save(floor));
        }
        return Optional.empty();
    }

    @Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "0")})
    public void delete(final long id) {
        floorRepo.deleteById(id);
    }
}