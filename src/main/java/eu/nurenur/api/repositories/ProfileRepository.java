package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
