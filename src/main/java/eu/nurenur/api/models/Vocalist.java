package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vocalists")
public class Vocalist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String engine;

    @Column
    private String URL;

    public Vocalist(
            String name,
            String engine,
            String URL
    )
    {
        this.name = name;
        this.engine = engine;
        this.URL = URL;
    }
}
