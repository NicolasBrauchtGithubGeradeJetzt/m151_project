package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "building", schema = "public")
public class Building implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_sequence")
    @SequenceGenerator(allocationSize = 1, name = "building_sequence")
    @Column(name = "building_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "building_description", unique = true)
    private String description;

    @Column(name = "adress", nullable = false, unique = true)
    private String adress;

    @Column(name = "price", nullable = false, unique = true)
    private float price;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_person_id", nullable = false, unique = true)
    private Person person;

    protected Building(){

    }

    public Building(String description, String adress, float price, Person person){
        this.description = description;
        this.adress = adress;
        this.price = price;
        this.person = person;
    }

    public long getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String getAdress(){
        return adress;
    }

    public float getPrice(){
        return price;
    }

    public Person getPerson(){
        return person;
    }
}