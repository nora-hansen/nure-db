package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    /*
        TODO
            Calculate age from birthday?
     */
    @Column
    private int age;

    @Column
    private String bio;

    @OneToMany(mappedBy = "group")
    private Group groups;

    @Column
    private boolean isOC;


    /*
        TODO
            Include Artwork when made
     */
    @OneToOne(mappedBy = "artwork")
    private Artwork iconImage;

    @OneToMany(mappedBy = "artwork")
    private List<Artwork> images;
}
