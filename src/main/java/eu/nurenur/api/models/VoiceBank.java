package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @Column
    private String name;

    @Column
    private String engine;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    public VoiceBank(String name, String engine) {
        this.name = name;
        this.engine = engine;
    }
}
