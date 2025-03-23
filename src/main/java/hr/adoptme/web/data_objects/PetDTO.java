package hr.adoptme.web.data_objects;

import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;

public class PetDTO {
        private Long id;
        private String name;
        private int age;
        private Gender gender;
        private String species;
        private Long shelterId;
        private Health health;
        private Availability availability;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public Gender getGender() { return gender; }
        public void setGender(Gender gender) { this.gender = gender; }

        public String getSpecies() { return species; }
        public void setSpecies(String species) { this.species = species; }

        public Long getShelterId() { return shelterId; }
        public void setShelterId(Long shelterId) { this.shelterId = shelterId; }

        public Health getHealth() { return health; }
        public void setHealth(Health health) { this.health = health; }

        public Availability getAvailability() { return availability; }
        public void setAvailability(Availability availability) { this.availability = availability; }
}
