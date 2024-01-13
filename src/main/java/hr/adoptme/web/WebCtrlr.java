package hr.adoptme.web;

import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.repos.PetRepo;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebCtrlr {

    @Autowired
    private PetRepo petRepo;

    @GetMapping("/hello")
    public List<Pet> getPets() {
        return petRepo.findAll();
    }

    @PostMapping("/add")
    public Pet savePet(@RequestBody String pet) {
        return petRepo.save(new Pet(pet));
    }
}