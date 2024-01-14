package hr.adoptme.web.repos;

import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.classes.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepo extends JpaRepository<Shelter, Long> {
}
