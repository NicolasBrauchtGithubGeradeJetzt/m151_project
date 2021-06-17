package ch.bbzw.m151.houseConstruct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group", schema = "public")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sequence")
    @SequenceGenerator(allocationSize = 1, name = "group_sequence")
    @Column(name = "group_id", nullable = false, updatable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_description", nullable = false, unique = true)
    private UserGroup description;

    protected Group(){

    }

    public Group(UserGroup description){
        this.description = description;
    }

    public long getId(){
        return id;
    }

    public UserGroup getDescription(){
        return description;
    }
}