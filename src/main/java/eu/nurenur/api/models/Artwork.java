package eu.nurenur.api.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/*
    TODO
        Double check relationships...
 */
@Entity
@Table(name = "artworks")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date date;

    @Column
    private String software;

    /*
        RELATIONSHIPS
     */

    // https://www.baeldung.com/hibernate-many-to-many
    @OneToMany(mappedBy = "artwork")
    private List<Source> availableAt;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "Artwork_Character",
            joinColumns = { @JoinColumn(name = "artwork_id")},
            inverseJoinColumns = { @JoinColumn(name = "character_id")}
    )
    private List<Character> charactersInWork;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Artwork_Tag",
            joinColumns = { @JoinColumn(name = "artwork_id")},
            inverseJoinColumns = { @JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags;
}
