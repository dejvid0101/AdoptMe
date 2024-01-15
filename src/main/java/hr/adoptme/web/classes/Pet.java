package hr.adoptme.web.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import jakarta.persistence.*;

@Entity
public class Pet {

    public Pet() {
    }

    public Pet(String name, int age, Gender gender, String species, Shelter shelter, Health health, Availability availability) {
        Name = name;
        Age = age;
        Gender = gender;
        Species = species;
        Shelter = shelter;
        Health = health;
        Availability = availability;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String Name;

    public int Age;

    @Enumerated(EnumType.STRING)
    public Gender Gender;

    public String Species;

    @ManyToOne
    @JsonIgnore
    public Shelter Shelter;

    @Enumerated(EnumType.STRING)
    public Health Health;

    @Enumerated(EnumType.STRING)
    public Availability Availability;

    // other fields

    // getters and setters
}
