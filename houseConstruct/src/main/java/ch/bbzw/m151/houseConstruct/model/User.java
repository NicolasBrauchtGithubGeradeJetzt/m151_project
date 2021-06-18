package ch.bbzw.m151.houseConstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "public")
@NamedQuery(name = "User.checkPassword", query = "SELECT u " 
                                                    + "FROM User u "
                                                    + "WHERE u.person.email = :email "
                                                    + "AND user_password = public.crypt(text(:password), text(user_password))")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(allocationSize = 1, name = "user_sequence")
    @Column(name = "user_id", nullable = false, updatable = false)
    private long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "user_password", nullable = false, unique = true)
    @ColumnTransformer(write = "crypt(?, gen_salt('bf', 8))")
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_person_id", nullable = false, unique = true)
    private Person person;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_group_id", nullable = false, unique = true)
    private Group group;

    protected User(){

    }

    public User(String password, Person person, Group group) {
        this.password = password;
        this.person = person;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public Group getGroup() {
        return group;
    }
}