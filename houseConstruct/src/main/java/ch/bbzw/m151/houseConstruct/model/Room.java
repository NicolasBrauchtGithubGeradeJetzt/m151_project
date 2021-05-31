package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_sequence")
    @SequenceGenerator(allocationSize = 1, name = "room_sequence")
    @Column(name = "room_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "room_description", unique = true)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_floor_id", nullable = false, unique = true)
    private Floor floor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "furniture_placement",
            joinColumns = {
                    @JoinColumn(name = "fk_room_id", referencedColumnName = "room_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_furniture_id", referencedColumnName = "furniture_id", nullable = false, updatable = false)})
    private Set<Furniture> furnitures = new HashSet<Furniture>();

    public Room(){

    }
}