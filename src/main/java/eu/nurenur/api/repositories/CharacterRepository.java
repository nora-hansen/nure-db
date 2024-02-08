package eu.nurenur.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.nurenur.api.models.Character;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
