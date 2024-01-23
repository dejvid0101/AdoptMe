package hr.adoptme.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.adoptme.web.classes.*;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import hr.adoptme.web.repos.AdopterRepo;
import hr.adoptme.web.repos.OfferRepo;
import hr.adoptme.web.repos.PetRepo;
import hr.adoptme.web.repos.ShelterRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WebCtrlr {

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private ShelterRepo shelterRepo;

    @Autowired
    private OfferRepo offerRepo;

    @Autowired
    private AdopterRepo adopterRepo;

    @GetMapping("/getPets")
    //@RequestMapping(value = "/getPets", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> getPets() {
        return petRepo.findAll();
    }

    @GetMapping("/getShelter")
    public Optional<Shelter> getShelter(@RequestParam Long id) {
        return shelterRepo.findById(id);
    }

    @GetMapping("/getShelters")
    public List<Shelter> getShelters() {
        return shelterRepo.findAll();
    }

    @GetMapping("/getOffers")
    public List<AdoptionOffer> getOffers() {
        return offerRepo.findAll();
    }

    @GetMapping("/getOffer")
    public Optional<AdoptionOffer> getOffer(@RequestParam Long id) {
        return offerRepo.findById(id);
    }

    @PostMapping("/addPet")
    public Pet savePet(@RequestBody String pet) {
        Shelter shelterr=new Shelter();
        shelterRepo.save(shelterr);
        return petRepo.save(new Pet("Fefe",6, Gender.FEMALE,"Kornjača", shelterr, Health.HEALTHY, Availability.AVAILABLE));
    }

    @PostMapping("/addShelter")
    public Shelter saveShelter(@RequestBody String shelter) {
        return shelterRepo.save(new Shelter());
        }

    @PostMapping("/addOffer")
    public AdoptionOffer saveOffer(@RequestBody String JSONoffer) throws JsonProcessingException {

        ObjectMapper o=new ObjectMapper();
        AdoptionOfferJSON newOfferJSON=o.readValue(JSONoffer, AdoptionOfferJSON.class); // create offer object from received json

        adopterRepo.save(newOfferJSON.getAdopter()); // save adopter info

        Optional<Pet> pet=petRepo.findById(newOfferJSON.getPet().id);

        newOfferJSON.setShelter(pet.get().Shelter); // set offer shelter from pet with id

        newOfferJSON.setPet(pet.get()); // set pet from db to offer

        AdoptionOffer newOffer=new AdoptionOffer(newOfferJSON.getPet(), newOfferJSON.getShelter(),
                newOfferJSON.getAdopter(), newOfferJSON.getAdoptionTerms());

        System.out.println(newOffer.getPetId());

        // find pet and save its shelter to adoptionoffer, then save

        //Shelter shelter=shelterRepo.getById(adoptionOffer.getShelter().id);

        //System.out.println(shelter);

        return offerRepo.save(newOffer);
        }

    @PostMapping("/addAdopter")
    public Adopter saveAdopter(@RequestBody String JSONadopter) throws JsonProcessingException {
        ObjectMapper o=new ObjectMapper();

        Adopter adopter=o.readValue(JSONadopter, Adopter.class);
        System.out.println(adopter.Phone);

        return adopterRepo.save(adopter);
    }

    @GetMapping("/getAdopter")
    public Optional<Adopter> getAdopter(@RequestParam Long id) {
        return adopterRepo.findById(id);
    }
}