package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Integer> {
}
