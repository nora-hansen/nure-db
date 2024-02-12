package eu.nurenur.api.models;

import jakarta.persistence.*;

import java.util.Date;

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

    @OneToOne
    private Source iconImage;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;
}
