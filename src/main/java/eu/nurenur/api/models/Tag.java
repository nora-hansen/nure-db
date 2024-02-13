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
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String value;   // Tag value

    @ManyToMany(mappedBy = "tags")
    @JoinTable(
            name = "Artwork_Tag",
            joinColumns = { @JoinColumn(name = "artwork_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private List<Artwork> artworks;

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

    public Tag(String value)
    {
        this.value = value;
    }
}
