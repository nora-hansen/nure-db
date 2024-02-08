package eu.nurenur.api.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String title;

    @Column
    private int seconds;

    @Column
    private Date firstDate;

    @Column
    private Date latestDate;

    @Column
    private String DAW;

    @Column
    private String description;

    @Column
    private String lyrics;

    @Column
    private String isrc;

    @ManyToOne
    @JoinColumn(name = "original_song_id", nullable = true)
    private Music originalSong;

    @Column
    private boolean isRemake;

    @OneToMany(mappedBy = "vocalist")
    private List<Vocalist> vocalists;

    @OneToMany
    private List<Source> availableAt;

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
}
