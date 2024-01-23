package hr.adoptme.web.classes;

import jakarta.persistence.*;

@Entity
public class AdoptionOfferJSON {

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pet pet;

    @OneToOne
    private Shelter Shelter;
    @OneToOne
    private Adopter adopter;

    private String adoptionTerms;

    public AdoptionOfferJSON() {
    }

    public AdoptionOfferJSON(Pet pet, Shelter shelter, Adopter adopter, String adoptionTerms) {
        this.pet = pet;

    }

    public Long getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Shelter getShelter() {
        return Shelter;
    }

    public void setShelter(Shelter shelter) {
        this.Shelter = shelter;
    }

    public String getAdoptionTerms() {
        return adoptionTerms;
    }

    public void setAdoptionTerms(String adoptionTerms) {
        this.adoptionTerms = adoptionTerms;
    }
}
