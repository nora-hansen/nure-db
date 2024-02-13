package eu.nurenur.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vocalists")
public class Vocalist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;    // Name of vocalist

    @Column
    private String engine;  // Engine vocalist uses

    @Column
    private String URL; // URL to information about vocalist

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

    public Vocalist(String name)   {
        this.name = name;
    }
}
