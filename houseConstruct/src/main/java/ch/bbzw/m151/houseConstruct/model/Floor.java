package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "floor")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_building_id", nullable = false, unique = true)
    private Building building;

    public Floor(){

    }
}