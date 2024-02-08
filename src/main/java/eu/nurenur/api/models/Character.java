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

    @Column
    private boolean isOC;

    /*
        RELATIONSHIPS
     */
    @ManyToMany(mappedBy = "characters")
    private List<Artwork> artworks;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groups;



    /*
        TODO
            Include Artwork when made
     */
    @OneToOne(mappedBy = "artwork")
    private Artwork iconImage;

    @OneToMany(mappedBy = "artwork")
    private List<Artwork> images;
}
