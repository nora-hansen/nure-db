package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String URL;

    @Column
    private String host;

    @Column
    private boolean isPublic;

    public Source(
            String URL,
            String host,
            boolean isPublic
            )
    {
        this.URL      = URL;
        this.host     = host;
        this.isPublic = isPublic;
    }
}
