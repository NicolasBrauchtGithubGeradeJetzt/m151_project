package ch.bbzw.m151.houseConstruct.service;

import ch.bbzw.m151.houseConstruct.model.Room;
import ch.bbzw.m151.houseConstruct.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = {"room"})
public class RoomService {

    private final RoomRepo roomRepo;

    @Autowired
    public RoomService(final RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "0")
    public List<Room> getAll() {
        final Iterable<Room> room = roomRepo.findAll();
        return StreamSupport
                .stream(room.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "#id", unless = "#result == null")
    public Optional<Room> get(final long id) {
       return Optional.ofNullable(roomRepo.findById(id));
    }

    @Transactional
    @CachePut(key = "#room.id")
    @CacheEvict(key = "0")
    public Room add(final Room room) {
        return roomRepo.save(room);
    }

    @Transactional
    public Optional<Room> update(final Room room) {
        final Optional<Room> optionalRoom = this.get(room.getId());
        if (optionalRoom.isPresent()) {
            return Optional.of(roomRepo.save(room));
        }
        return Optional.empty();
    }

    @Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "0")})
    public void delete(final long id) {
        roomRepo.deleteById(id);
    }
}