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
@Table(name = "sources")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;    // Idk what I meant by this

    @Column(nullable = false)
    private String URL; // Link to source (if local, filepath)

    @Column
    private String host;    // Name of the host (e.g. YouTube, OneDrive, Local...)

    @Column
    private boolean isPublic;   // Is it publically available (if not, authentication needed to access)

    @ManyToOne
    @JoinColumn(name = "artwork_id")
    private List<Artwork> artworks; // Artworksss

    @ManyToOne
    @JoinColumn(name = "music_id")
    private List<Music> music;  // Musicccc

    @ManyToOne
    @JoinColumn(name = "release_id")
    private List<Release> releases; // Releasesss

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

    public Source(
            String name,
            String URL,
            String host,
            boolean isPublic
            )
    {
        this.name     = name;
        this.URL      = URL;
        this.host     = host;
        this.isPublic = isPublic;
    }
}
