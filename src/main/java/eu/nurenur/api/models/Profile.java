package eu.nurenur.api.models;

import jakarta.persistence.*;

/*
    TODO
        - More fields?
        - Like alt names
 */
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
}
