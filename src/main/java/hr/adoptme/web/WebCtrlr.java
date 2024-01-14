package hr.adoptme.web;

import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.classes.Shelter;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import hr.adoptme.web.repos.PetRepo;
import hr.adoptme.web.repos.ShelterRepo;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebCtrlr {

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private ShelterRepo shelterRepo;

    @GetMapping("/getAll")
    public List<Pet> getPets() {
        return petRepo.findAll();
    }

    @PostMapping("/add")
    public Pet savePet(@RequestBody String pet) {
        Shelter shelterr=new Shelter();
        shelterRepo.save(shelterr);
        return petRepo.save(new Pet("Fefe",6, Gender.FEMALE,"Kornjača", shelterr, Health.HEALTHY, Availability.AVAILABLE));
    }
}