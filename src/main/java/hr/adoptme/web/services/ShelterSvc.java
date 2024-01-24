package hr.adoptme.web.services;

import hr.adoptme.web.classes.Shelter;
import hr.adoptme.web.repos.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterSvc {

    @Autowired
    private ShelterRepo ShelterRepo;

    public Optional<Shelter> findShelterById(Long id) {
        return ShelterRepo.findById(id);
    }

    public List<Shelter> findAllShelters() {
        return ShelterRepo.findAll();
    }

    public Shelter saveShelter(Shelter Shelter) {
        return ShelterRepo.save(Shelter);
    }

    public void deleteShelter(Long id) {
        ShelterRepo.deleteById(id);
    }
}

