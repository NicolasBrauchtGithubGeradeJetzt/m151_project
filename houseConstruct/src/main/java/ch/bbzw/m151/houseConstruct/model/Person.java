package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    @SequenceGenerator(allocationSize = 1, name = "person_sequence")
    @Column(name = "person_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "person_name", nullable = false, unique = true)
    private String name;

    @Column(name = "surname", nullable = false, unique = true)
    private String surname;

    @Column(name = "email_adress", nullable = false, unique = true)
    private String email;

    @Column(name = "telephone_number", unique = true)
    private String telephone;

    public Person(){

    }
}