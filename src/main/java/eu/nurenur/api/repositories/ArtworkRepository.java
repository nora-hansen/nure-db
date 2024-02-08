package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Integer> {
}
