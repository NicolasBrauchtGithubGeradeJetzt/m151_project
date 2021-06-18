package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "room", schema = "public")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_sequence")
    @SequenceGenerator(allocationSize = 1, name = "room_sequence")
    @Column(name = "room_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "room_description", unique = true)
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_floor_id", nullable = false, unique = true)
    private Floor floor;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "furniture_placement",
            joinColumns = {
                    @JoinColumn(name = "fk_room_id", referencedColumnName = "room_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_furniture_id", referencedColumnName = "furniture_id", nullable = false, updatable = false)})
    private Set<Furniture> furnitures = new HashSet<Furniture>();

    protected Room(){

    }

    public Room(String description, Floor floor, Set<Furniture> furnitures){
            this.description = description;
            this.floor = floor;
            this.furnitures = furnitures;
    }

    public long getId(){
        return id;
    }

    public Floor getFloor(){
        return floor;
    }

    public Set<Furniture> getFurnitures(){
            return furnitures;
    }
}