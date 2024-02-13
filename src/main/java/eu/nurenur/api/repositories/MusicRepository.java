package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {
}
