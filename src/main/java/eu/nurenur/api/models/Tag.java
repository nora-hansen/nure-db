package eu.nurenur.api.models;

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
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String value;

    @ManyToMany(mappedBy = "tags")
    private List<Artwork> artworks;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    public Tag(String value)
    {
        this.value = value;
    }
}
