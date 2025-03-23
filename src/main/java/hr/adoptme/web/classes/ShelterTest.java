package hr.adoptme.web.classes;

import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ShelterTest {

   /* @Test
    public void testShelterInitialization() {
        Shelter shelter = new Shelter();
        assertNull(shelter.getId());
        assertNull(shelter.getPets());
        assertNull(shelter.getAdoptionOffers());
    }

    @Test
    public void testIdGetterAndSetter() {
        Shelter shelter = new Shelter();
        shelter.id=1L;
        assertEquals(1L, shelter.getId());
    }
    @Test
    public void testPetsGetterAndSetter() {
        Shelter shelter = new Shelter();
        List<Pet> pets = new ArrayList<>();
        Pet expectedPet = new Pet("Fifi", 3, Gender.MALE, "Mačka", new Shelter(), Health.HEALTHY, Availability.AVAILABLE);
        pets.add(expectedPet);
        shelter.setPets(pets);
        assertEquals(pets, shelter.getPets());
    }

    @Test
    public void testAdoptionOffersGetterAndSetter() {
        Shelter shelter = new Shelter();
        List<AdoptionOffer> adoptionOffers = new ArrayList<>();
        adoptionOffers.add(new AdoptionOffer());
        shelter.setAdoptionOffers(adoptionOffers);
        assertEquals(adoptionOffers, shelter.getAdoptionOffers());
    }*/
}
