package eu.nurenur.api.repositories;

import eu.nurenur.api.models.VoiceBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoiceBankRepository extends JpaRepository<VoiceBank, Integer> {
}
