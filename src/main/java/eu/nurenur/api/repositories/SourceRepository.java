package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Integer> {
}
