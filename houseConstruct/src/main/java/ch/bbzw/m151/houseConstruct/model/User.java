package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(allocationSize = 1, name = "user_sequence")
    @Column(name = "user_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "user_password", nullable = false, unique = true)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_person_id", nullable = false, unique = true)
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group_id", nullable = false, unique = true)
    private Group group;

    public User(){

    }
}