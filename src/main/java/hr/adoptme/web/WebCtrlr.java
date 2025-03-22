package hr.adoptme.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.adoptme.web.classes.*;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import hr.adoptme.web.services.AdopterSvc;
import hr.adoptme.web.services.OfferSvc;
import hr.adoptme.web.services.PetSvc;
import hr.adoptme.web.services.ShelterSvc;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WebCtrlr {

    @Autowired
    private PetSvc petSvc;

    @Autowired
    private ShelterSvc shelterSvc;

    @Autowired
    private OfferSvc offerSvc;

    @Autowired
    private AdopterSvc adopterSvc;

    @GetMapping("/getPets")
    //@RequestMapping(value = "/getPets", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> getPets() {
        return petSvc.findAllPets();
    }

    @GetMapping("/getShelter")
    public Optional<Shelter> getShelter(@RequestParam Long id) {
        return shelterSvc.findShelterById(id);
    }

    @GetMapping("/getPet")
    public Optional<Pet> getPet(@RequestParam Long id) {
        return petSvc.findPetById(id);
    }

    @GetMapping("/getShelters")
    public List<Shelter> getShelters() {
        return shelterSvc.findAllShelters();
    }

    @GetMapping("/getOffers")
    public List<AdoptionOffer> getOffers() {
        return offerSvc.findAllOffers();
    }

    @GetMapping("/getOffer")
    public Optional<AdoptionOffer> getOffer(@RequestParam Long id) {
        return offerSvc.findOfferById(id);
    }

    @PostMapping("/addPet")
    public Pet savePet(@RequestBody Pet pet) {
        Shelter shelterr=new Shelter();
        shelterSvc.saveShelter(shelterr);
        //throw new RuntimeException("addPet not implemented");
        return petSvc.savePet(new Pet("Fefe",6, Gender.FEMALE,"Kornjača", shelterr, Health.HEALTHY, Availability.AVAILABLE));
    }

    @PostMapping("/addShelter")
    public Shelter saveShelter(@RequestBody String shelter) {
        throw new RuntimeException("addShelter not implemented");
        //return shelterSvc.saveShelter(new Shelter());
        }

    @PostMapping("/addOffer")
    public AdoptionOffer saveOffer(@RequestBody String JSONoffer) throws JsonProcessingException {

        ObjectMapper o=new ObjectMapper();
        AdoptionOfferJSON newOfferJSON=o.readValue(JSONoffer, AdoptionOfferJSON.class); // create offer object from received json

        adopterSvc.saveAdopter(newOfferJSON.getAdopter()); // save adopter info

        Optional<Pet> pet=petSvc.findPetById(newOfferJSON.getPet().id);

        newOfferJSON.setShelter(pet.get().Shelter); // set offer shelter from pet with id

        newOfferJSON.setPet(pet.get()); // set pet from db to offer

        AdoptionOffer newOffer=new AdoptionOffer(newOfferJSON.getPet(), newOfferJSON.getShelter(),
                newOfferJSON.getAdopter(), newOfferJSON.getAdoptionTerms());

        return offerSvc.saveOffer(newOffer);
        }

    @PostMapping("/addAdopter")
    public Adopter saveAdopter(@RequestBody String JSONadopter) throws JsonProcessingException {
        ObjectMapper o=new ObjectMapper();

        // TODO: 22/03/2025 remove ObjectMapper 
        
        Adopter adopter=o.readValue(JSONadopter, Adopter.class);
        System.out.println(adopter.Phone);

        return adopterSvc.saveAdopter(adopter);
    }

    @GetMapping("/getAdopter")
    public Optional<Adopter> getAdopter(@RequestParam Long id) {
        return adopterSvc.findAdopterById(id);
    }
}