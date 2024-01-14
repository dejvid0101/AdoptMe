package hr.adoptme.web.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AdoptionOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pet pet;

    @OneToOne
    private Shelter Shelter;

    private String adoptionTerms;

    public AdoptionOffer() {
    }

    public AdoptionOffer(Pet pet, Shelter shelter, String adoptionTerms) {
        this.pet = pet;
        this.Shelter = shelter;
        this.adoptionTerms = adoptionTerms;
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
