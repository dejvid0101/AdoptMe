package hr.adoptme.web.classes;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AdoptionOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @ManyToOne
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    private String adoptionTerms;

    // Constructors
    public AdoptionOffer() {}

    public AdoptionOffer(Pet pet, Shelter shelter, Adopter adopter, String adoptionTerms) {
        this.pet = pet;
        this.shelter = shelter;
        this.adopter = adopter;
        this.adoptionTerms = adoptionTerms;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public Shelter getShelter() { return shelter; }
    public void setShelter(Shelter shelter) { this.shelter = shelter; }

    public Adopter getAdopter() { return adopter; }
    public void setAdopter(Adopter adopter) { this.adopter = adopter; }

    public String getAdoptionTerms() { return adoptionTerms; }
    public void setAdoptionTerms(String adoptionTerms) { this.adoptionTerms = adoptionTerms; }
}