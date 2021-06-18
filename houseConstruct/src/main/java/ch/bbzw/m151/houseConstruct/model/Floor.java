package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "floor", schema = "public")
public class Floor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "floor_sequence")
    @SequenceGenerator(allocationSize = 1, name = "floor_sequence")
    @Column(name = "floor_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "floor_number", nullable = false, unique = true)
    private int number;

    @Column(name = "floor_description", unique = true)
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_building_id", nullable = false, unique = true)
    private Building building;

    protected Floor(){

    }

    public Floor(int number, String description, Building building){
        this.number = number;
        this.description = description;
        this.building = building;
    }

    public long getId(){
        return id;
    }

    public int getNumber(){
        return number;
    }

    public String getDescription(){
        return description;
    }

    public Building getBuilding(){
        return building;
    }
}