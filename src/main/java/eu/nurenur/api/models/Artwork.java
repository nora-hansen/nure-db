package eu.nurenur.api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
    private String title;   // Title of work

    @Column
    private String description; // Description of work

    @Column
    private LocalDateTime date; // Approx. date of creation

    @Column
    private String software;    // If digital, what software was used

    /*
        RELATIONSHIPS
     */

    // https://www.baeldung.com/hibernate-many-to-many
    @OneToMany(mappedBy = "artwork")
    private List<Source> availableAt;   // Where can it be found

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "Artwork_Character",
            joinColumns = { @JoinColumn(name = "artwork_id")},
            inverseJoinColumns = { @JoinColumn(name = "character_id")}
    )
    private List<Character> charactersInWork;   // What characters are included

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Artwork_Tag",
            joinColumns = { @JoinColumn(name = "artwork_id")},
            inverseJoinColumns = { @JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags; // Descriptive tags

    @CreationTimestamp
    private LocalDateTime createdAt;    // When was entry created
    @PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = LocalDateTime.now();
    }

    @UpdateTimestamp
    private  LocalDateTime updatedAt;   // When was entry last updated
    @PreUpdate
    protected void onUpdate()   {
        this.updatedAt = LocalDateTime.now();
    }

    public Artwork(
            String title,
            String description,
            LocalDateTime date,
            String software
    )   {
        this.title       = title;
        this.description = description;
        this.date        = date;
        this.software    = software;
    }

    public Artwork(
            String title,
            String description,
            LocalDateTime date,
            String software,
            List<Source> availableAt,
            List<Character> charactersInWork,
            List<Tag> tags
    )   {
        this.title            = title;
        this.description      = description;
        this.date             = date;
        this.software         = software;
        this.availableAt      = availableAt;
        this.charactersInWork = charactersInWork;
        this.tags             = tags;
    }
}
