package eu.nurenur.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "artworks")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
