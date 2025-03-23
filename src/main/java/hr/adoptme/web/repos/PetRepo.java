package hr.adoptme.web.repos;

import hr.adoptme.web.classes.Pet;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PetRepo extends JpaRepository<Pet, Long> {
    // You can define custom queries here if needed
}