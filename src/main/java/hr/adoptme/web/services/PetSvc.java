package hr.adoptme.web.services;

import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.repos.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetSvc {

    @Autowired
    private PetRepo petRepo;

    public Optional<Pet> findPetById(Long id) {
        return petRepo.findById(id);
    }

    public List<Pet> findAllPets() {
        return petRepo.findAll();
    }

    public Pet savePet(Pet Pet) {
        return petRepo.save(Pet);
    }

    public void deletePet(Long id) {
        petRepo.deleteById(id);
    }
}
