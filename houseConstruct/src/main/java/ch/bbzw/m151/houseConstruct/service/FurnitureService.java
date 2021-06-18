package ch.bbzw.m151.houseConstruct.service;

import ch.bbzw.m151.houseConstruct.model.Furniture;
import ch.bbzw.m151.houseConstruct.repo.FurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = {"furniture"})
public class FurnitureService {

    private final FurnitureRepo furnitureRepo;

    @Autowired
    public FurnitureService(final FurnitureRepo furnitureRepo) {
        this.furnitureRepo = furnitureRepo;
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "0")
    public List<Furniture> getAll() {
        final Iterable<Furniture> furniture = furnitureRepo.findAll();
        return StreamSupport
                .stream(furniture.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "#id", unless = "#result == null")
    public Optional<Furniture> get(final long id) {
       return Optional.ofNullable(furnitureRepo.findById(id));
    }

    @Transactional
    @CachePut(key = "#furniture.id")
    @CacheEvict(key = "0")
    public Furniture add(final Furniture furniture) {
        return furnitureRepo.save(furniture);
    }

    @Transactional
    public Optional<Furniture> update(final Furniture furniture) {
        final Optional<Furniture> optionalFurniture = this.get(furniture.getId());
        if (optionalFurniture.isPresent()) {
            return Optional.of(furnitureRepo.save(furniture));
        }
        return Optional.empty();
    }

    @Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "0")})
    public void delete(final long id) {
        furnitureRepo.deleteById(id);
    }
}