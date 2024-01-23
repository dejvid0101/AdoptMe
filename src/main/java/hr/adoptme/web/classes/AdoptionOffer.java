package hr.adoptme.web.classes;

import jakarta.persistence.*;

@Entity
public class AdoptionOffer {

    public Long getAdopterId() {
        return adopterId;
    }

    public void setAdopter(Adopter adopter) {
        this.adopterId = adopter.id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long petId;
    private Long shelterId;
    private Long adopterId;

    private String adoptionTerms;

    public AdoptionOffer() {
    }

    public AdoptionOffer(Pet pet, Shelter shelter, Adopter adopter, String adoptionTerms) {
        this.petId = pet.id;
        this.shelterId= shelter.getId();
        this.adopterId=adopter.id;
        this.adoptionTerms=adoptionTerms;

    }

    public Long getId() {
        return id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPet(Pet pet) {
        this.petId = pet.id;
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelter(Shelter shelter) {
        this.shelterId = shelter.getId();
    }

    public String getAdoptionTerms() {
        return adoptionTerms;
    }

    public void setAdoptionTerms(String adoptionTerms) {
        this.adoptionTerms = adoptionTerms;
    }
}
