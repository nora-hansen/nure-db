package eu.nurenur.api.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "releases")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private Date date;

    @OneToMany(mappedBy = "music")
    private List<Music> songs;

    @OneToMany(mappedBy = "source")
    private List<Source> availableAt;

    @OneToOne(mappedBy = "artwork")
    private Artwork cover;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    public Release(
            String title,
            Date date,
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
