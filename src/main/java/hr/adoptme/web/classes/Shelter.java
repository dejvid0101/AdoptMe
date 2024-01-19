package hr.adoptme.web.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Shelter {
    public Shelter() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany(mappedBy = "Shelter")
    public List<Pet> pets;

    @OneToMany(mappedBy = "Shelter")
    public List<AdoptionOffer> adoptionOffers;

    // Other fields, constructors, getters, and setters

    public String name;

    public String address;


    public Long getId() {
        return id;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<AdoptionOffer> getAdoptionOffers() {
        return adoptionOffers;
    }

    public void setAdoptionOffers(List<AdoptionOffer> adoptionOffers) {
        this.adoptionOffers = adoptionOffers;
    }
}
