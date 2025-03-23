package hr.adoptme.web.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.adoptme.web.classes.AdoptionOffer;
import hr.adoptme.web.classes.Pet;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "shelter")
    private List<Pet> pets;

    @OneToMany(mappedBy = "shelter")
    private List<AdoptionOffer> adoptionOffers;

    public Shelter() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Collections should typically only expose getters
    public List<Pet> getPets() {
        return pets;
    }

    public List<AdoptionOffer> getAdoptionOffers() {
        return adoptionOffers;
    }
}