package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
