package hr.adoptme.web.classes;

import jakarta.persistence.*;

@Entity
public class Adopter {

    public Adopter() {
    }

    public Adopter(Long id, String name, String email, String phone, String password) {
        this.id = id;
        Name = name;
        Email = email;
        Phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String Name;

    public String Email;

    public String Phone;

    // other fields

    // getters and setters
}

