package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;

    @Column
    private String URL;

    @Column
    private String host;

    @Column
    private boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "artwork_id")
    private List<Artwork> artworks;

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
