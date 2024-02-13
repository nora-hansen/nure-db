package eu.nurenur.api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "releases")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private final String title;   // Title of release

    @Column
    private LocalDateTime date;  // Date of release

    @OneToMany(mappedBy = "music")
    private List<Music> songs;  // Songs in release

    @OneToMany(mappedBy = "source")
    private List<Source> availableAt;   // Where release can be found

    @OneToOne(mappedBy = "artwork")
    private Artwork cover;  // Cover artwork for release

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

    public Release(
            String title,
            LocalDateTime date,
            List<Music> songs,
            List<Source> availableAt
            )
    {
        this.title       = title;
        this.date        = date;
        this.songs       = songs;
        this.availableAt = availableAt;
    }
}
