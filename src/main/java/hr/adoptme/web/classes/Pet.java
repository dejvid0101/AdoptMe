package hr.adoptme.web.classes;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String species;

    @ManyToOne
    private Shelter shelter;

    @Enumerated(EnumType.STRING)
    private Health health;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    // Constructors
    public Pet() {
    }

    public Pet(String name, int age, Gender gender, String species,
               Shelter shelter, Health health, Availability availability) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.shelter = shelter;
        this.health = health;
        this.availability = availability;
    }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", species='" + species + '\'' +
                ", shelter=" + (shelter != null ? shelter.getId() : null) +
                ", health=" + health +
                ", availability=" + availability +
                '}';
    }
}