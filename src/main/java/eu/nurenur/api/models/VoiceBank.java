package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/*
    TODO
        - Add rest of fields
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "voice_banks")
public class VoiceBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;    // Name of voicebank

    @Column
    private String engine;  // Engine voicebank is made for

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile voiceProvider;  // Voice provider

    @Column
    private String termsOfUse;   // Terms of use

    @ManyToMany
    @JoinTable(
            name = "Voicebank_Source",
            joinColumns = { @JoinColumn(name = "voicebank_id") },
            inverseJoinColumns = { @JoinColumn(name = "source_id") }
    )
    private List<Source> availableAt;

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

    public VoiceBank(String name,
                     String engine,
                     Profile voiceProvider) {
        this.name   = name;
        this.engine = engine;
        this.voiceProvider = voiceProvider;
    }

    public VoiceBank(
            String name,
            String engine,
            Profile voiceProvider,
            String termsOfUse
            ) {
        this.name   = name;
        this.engine = engine;
        this.voiceProvider = voiceProvider;
        this.termsOfUse    = termsOfUse;
    }

    public VoiceBank(
            String name,
            String engine,
            Profile voiceProvider,
            String termsOfUse,
            List<Source> availableAt
    ) {
        this.name   = name;
        this.engine = engine;
        this.voiceProvider = voiceProvider;
        this.termsOfUse    = termsOfUse;
        this.availableAt   = availableAt;
    }
}
