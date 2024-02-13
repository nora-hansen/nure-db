package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private String name;    // Name of character

    @Column
    private int age;    // Their age

    @Column
    private String bio; // A bio / description

    @Column(nullable = false)
    private boolean isOC;   // Is this an OC?

    /*
        RELATIONSHIPS
     */
    @ManyToMany(mappedBy = "characters")
    @JoinTable(
            name = "Artwork_Character",
            joinColumns = { @JoinColumn(name = "artwork_id")},
            inverseJoinColumns = { @JoinColumn(name = "character_id")}
    )
    private List<Artwork> artworks; // Artworks of the characters

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;   // Group character is part of

    @OneToOne(mappedBy = "artwork")
    private Artwork iconImage;  // Icon image of character

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

    public Character(
            String name,
            boolean isOC
    )   {
        this.name = name;
        this.isOC = isOC;
    }

    public Character(
            String name,
            int age,
            String bio,
            boolean isOC,
            List<Artwork> artworks,
            Group group,
            Artwork iconImage
    )   {
        this.name  = name;
        this.age   = age;
        this.bio   = bio;
        this.isOC  = isOC;
        this.artworks  = artworks;
        this.group = group;
        this.iconImage = iconImage;
    }
}
