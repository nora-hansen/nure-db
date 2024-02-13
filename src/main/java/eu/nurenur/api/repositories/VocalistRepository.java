package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Vocalist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocalistRepository extends JpaRepository<Vocalist, Integer> {
}
