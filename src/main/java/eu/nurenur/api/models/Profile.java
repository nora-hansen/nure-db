package eu.nurenur.api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(nullable = false)
    private final String name;    // Name of profile/person

    @OneToOne
    private Source iconImage;   // Image

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
    @OneToMany(mappedBy = "profile")
    private List<VoiceBank> voicebanks; // Voicebanks voiced by profile

    public Profile(
        String name,
        Source iconImage
    )   {
        this.name = name;
        this.iconImage = iconImage;
    }

    public Profile(
            String name
    )   {
        this.name = name;
    }

    public Profile(
            String name,
            Source iconImage,
            List<VoiceBank> voicebanks
    )   {
        this.name = name;
        this.iconImage  = iconImage;
        this.voicebanks = voicebanks;
    }
}
