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
    private PetRepo PetRepo;

    public Optional<Pet> findPetById(Long id) {
        return PetRepo.findById(id);
    }

    public List<Pet> findAllPets() {
        return PetRepo.findAll();
    }

    public Pet savePet(Pet Pet) {
        return PetRepo.save(Pet);
    }

    public void deletePet(Long id) {
        PetRepo.deleteById(id);
    }
}
