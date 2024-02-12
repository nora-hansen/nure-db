package eu.nurenur.api.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;   // Title of song

    @Column
    private int seconds;    // Length in seconds

    @Column
    private Date firstDate; // First creation date

    @Column
    private Date latestDate;    // Latest export date

    @Column
    private String DAW; // DAW used

    @Column
    private String description; // Description/background/etc

    @Column
    private String lyrics;  // Lyrics (if exist)

    @Column
    private String isrc;    // Uh

    @ManyToOne
    @JoinColumn(name = "original_song_id", nullable = true)
    private Music originalSong; // IF a remix/remake/remaster, link to original version

    @Column
    private boolean isRemake;   // Bool if remake/remaster/remix

    @ManyToMany(mappedBy = "main_vocalist")
    private List<Vocalist> mainVocalists;   // Main vocalists present

    @ManyToMany(mappedBy = "back_vocalist")
    private List<Vocalist> backingVocalists;    // Backers present

    @ManyToMany(mappedBy = "sfx_vocalist")
    private List<Vocalist> sfxVocalists;    // Vocalists only providing sound effects

    @OneToMany(mappedBy = "available_at")
    private List<Source> availableAt;   // Where is it available

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

    public Music(
            String title,
            int seconds,
            Date firstDate,
            Date latestDate,
            String DAW,
            String description,
            String lyrics,
            String isrc,
            boolean isRemake
            )
    {
        this.title       = title;
        this.seconds     = seconds;
        this.firstDate   = firstDate;
        this.latestDate  = latestDate;
        this.DAW         = DAW;
        this.description = description;
        this.lyrics      = lyrics;
        this.isrc        = isrc;
        this.isRemake    = isRemake;
    }

    public Music (
            String title,
            int seconds,
            Date firstDate,
            Date latestDate,
            String DAW,
            String description,
            String lyrics,
            String isrc,
            boolean isRemake,
            List<Vocalist> mainVocalists,
            List<Vocalist> backingVocalists,
            List<Vocalist> sfxVocalists,
            List<Source> availableAt
    )   {
        this.title       = title;
        this.seconds     = seconds;
        this.firstDate   = firstDate;
        this.latestDate  = latestDate;
        this.DAW         = DAW;
        this.description = description;
        this.lyrics      = lyrics;
        this.isrc        = isrc;
        this.isRemake    = isRemake;
        this.mainVocalists = mainVocalists;
        this.backingVocalists = backingVocalists;
        this.sfxVocalists = sfxVocalists;
        this.availableAt = availableAt;
    }
}
