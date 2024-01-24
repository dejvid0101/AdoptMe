package hr.adoptme.web.services;

import hr.adoptme.web.classes.Adopter;
import hr.adoptme.web.repos.AdopterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopterSvc {

    @Autowired
    private AdopterRepo adopterRepo;

    public Optional<Adopter> findAdopterById(Long id) {
        return adopterRepo.findById(id);
    }

    public List<Adopter> findAllAdopters() {
        return adopterRepo.findAll();
    }

    public Adopter saveAdopter(Adopter adopter) {
        return adopterRepo.save(adopter);
    }

    public void deleteAdopter(Long id) {
        adopterRepo.deleteById(id);
    }
}
