package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "furniture", schema = "public")
public class Furniture implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "furniture_sequence")
    @SequenceGenerator(allocationSize = 1, name = "furniture_sequence")
    @Column(name = "furniture_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "furniture_description", unique = true)
    private String description;

    @Column(name = "price", nullable = false, unique = true)
    private float price;

    @ManyToMany(mappedBy = "furnitures", fetch = FetchType.EAGER)
    private Set<Room> rooms = new HashSet<Room>();

    protected Furniture(){

    }

    public Furniture(String description, float price, Set<Room> rooms){
        this.description = description;
        this.price = price;
        this.rooms = rooms;
    }

    public long getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public float getPrice(){
        return price;
    }

    public Set<Room> getRooms(){
        return rooms;
    }
}