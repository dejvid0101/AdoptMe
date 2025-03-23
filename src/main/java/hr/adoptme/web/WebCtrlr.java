package hr.adoptme.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import hr.adoptme.web.classes.*;
import hr.adoptme.web.data_objects.AdopterDTO;
import hr.adoptme.web.data_objects.AdoptionOfferDTO;
import hr.adoptme.web.data_objects.PetDTO;
import hr.adoptme.web.data_objects.ShelterDTO;
import hr.adoptme.web.services.AdopterSvc;
import hr.adoptme.web.services.OfferSvc;
import hr.adoptme.web.services.PetSvc;
import hr.adoptme.web.services.ShelterSvc;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<PetDTO> getPets() {
        return petSvc.findAllPets().stream()
                .map(this::convertToPetDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/getShelter")
    public ShelterDTO getShelter(@RequestParam Long id) {
        return shelterSvc.findShelterById(id)
                .map(this::convertToShelterDTO)
                .orElse(null);
    }

    @GetMapping("/getPet")
    public Optional<Pet> getPet(@RequestParam Long id) {
        return petSvc.findPetById(id);
    }

    @GetMapping("/getShelters")
    public List<ShelterDTO> getShelters() {
        return shelterSvc.findAllShelters().stream()
                .map(this::convertToShelterDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/getOffers")
    public List<AdoptionOfferDTO> getOffers() {
        return offerSvc.findAllOffers().stream()
                .map(this::convertToAdoptionOfferDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/getOffer")
    public Optional<AdoptionOffer> getOffer(@RequestParam Long id) {
        return offerSvc.findOfferById(id);
    }

    @PostMapping("/addPet")
    public PetDTO savePet(@RequestBody PetDTO petRequest) {
        return convertToPetDTO(petSvc.savePet(convertToPetEntity(petRequest)));
    }

    @PostMapping("/addShelter")
    public ShelterDTO saveShelter(@RequestBody ShelterDTO shelterRequest) {
        Shelter shelter = new Shelter();
        shelter.setName(shelterRequest.getName());
        shelter.setAddress(shelterRequest.getAddress());
        return convertToShelterDTO(shelterSvc.saveShelter(shelter));
    }

    @PostMapping("/addOffer")
    public AdoptionOfferDTO saveOffer(@RequestBody AdoptionOfferDTO offerRequest) {
        return convertToAdoptionOfferDTO(offerSvc.saveOffer(convertToAdoptionOfferEntity(offerRequest)));
    }

    @PostMapping("/addAdopter")
    public AdopterDTO saveAdopter(@RequestBody AdopterDTO adopterRequest) throws JsonProcessingException {
        return convertToAdopterDTO(adopterSvc.saveAdopter(convertToAdopterEntity(adopterRequest)));
    }

    @GetMapping("/getAdopter")
    public Optional<Adopter> getAdopter(@RequestParam Long id) {
        return adopterSvc.findAdopterById(id);
    }

    @GetMapping("/getAdopters")
    public List<AdopterDTO> getAdopters() {
        return adopterSvc.findAllAdopters().stream()
                .map(this::convertToAdopterDTO)
                .collect(Collectors.toList());
    }


    @DeleteMapping("/deletePet")
    public void deletePet(@RequestParam Long id) {
        petSvc.deletePet(id);
    }

    @DeleteMapping("/deleteShelter")
    public void deleteShelter(@RequestParam Long id) {
        shelterSvc.deleteShelter(id);
    }

    @DeleteMapping("/deleteAdopter")
    public void deleteAdopter(@RequestParam Long id) {
        adopterSvc.deleteAdopter(id);
    }

    @DeleteMapping("/deleteOffer")
    public void deleteOffer(@RequestParam Long id) {
        offerSvc.deleteOffer(id);
    }

    // utility methods for entity
    private Pet convertToPetEntity(PetDTO dto) {
        return new Pet(
                dto.getName(),
                dto.getAge(),
                dto.getGender(),
                dto.getSpecies(),
                shelterSvc.findShelterById(dto.getShelterId())
                        .orElseThrow(() -> new RuntimeException("Shelter not found")),
                dto.getHealth(),
                dto.getAvailability()
        );
    }

    private PetDTO convertToPetDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setAge(pet.getAge());
        dto.setGender(pet.getGender());
        dto.setSpecies(pet.getSpecies());
        dto.setShelterId(pet.getShelter().getId());
        dto.setHealth(pet.getHealth());
        dto.setAvailability(pet.getAvailability());
        return dto;
    }

    private Shelter convertToShelterEntity(ShelterDTO dto) {
        Shelter shelter = new Shelter();
        shelter.setName(dto.getName());
        shelter.setAddress(dto.getAddress());
        return shelter;
    }

    private ShelterDTO convertToShelterDTO(Shelter shelter) {
        ShelterDTO dto = new ShelterDTO();
        dto.setId(shelter.getId());
        dto.setName(shelter.getName());
        dto.setAddress(shelter.getAddress());
        return dto;
    }

    private AdoptionOffer convertToAdoptionOfferEntity(AdoptionOfferDTO dto) {
        return new AdoptionOffer(
                petSvc.findPetById(dto.getPetId())
                        .orElseThrow(() -> new RuntimeException("Pet not found")),
                shelterSvc.findShelterById(dto.getShelterId())
                        .orElseThrow(() -> new RuntimeException("Shelter not found")),
                adopterSvc.findAdopterById(dto.getAdopterId())
                        .orElseThrow(() -> new RuntimeException("Adopter not found")),
                dto.getAdoptionTerms()
        );
    }

    private AdoptionOfferDTO convertToAdoptionOfferDTO(AdoptionOffer offer) {
        AdoptionOfferDTO dto = new AdoptionOfferDTO();
        dto.setPetId(offer.getPet().getId());
        dto.setShelterId(offer.getShelter().getId());
        dto.setAdopterId(offer.getAdopter().getId());
        dto.setAdoptionTerms(offer.getAdoptionTerms());
        return dto;
    }

    private Adopter convertToAdopterEntity(AdopterDTO dto) {
        Adopter adopter = new Adopter();
        adopter.setName(dto.getName());
        adopter.setEmail(dto.getEmail());
        adopter.setPhone(dto.getPhone());
        return adopter;
    }

    private AdopterDTO convertToAdopterDTO(Adopter adopter) {
        AdopterDTO dto = new AdopterDTO();
        dto.setId(adopter.getId());
        dto.setName(adopter.getName());
        dto.setEmail(adopter.getEmail());
        dto.setPhone(adopter.getPhone());
        return dto;
    }
}