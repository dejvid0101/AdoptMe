package hr.adoptme.web.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdoptionOfferJSONTest {

    @Test
    public void testAdoptionOfferJSONInitialization() {
        AdoptionOfferJSON offer = new AdoptionOfferJSON();
        assertNull(offer.getId());
        assertNull(offer.getPet());
        assertNull(offer.getShelter());
        assertNull(offer.getAdopter());
        assertNull(offer.getAdoptionTerms());
    }

    @Test
    public void testPetGetterAndSetter() {
        AdoptionOfferJSON offer = new AdoptionOfferJSON();
        Pet pet = new Pet();
        offer.setPet(pet);
        assertEquals(pet, offer.getPet());
    }

    @Test
    public void testShelterGetterAndSetter() {
        AdoptionOfferJSON offer = new AdoptionOfferJSON();
        Shelter shelter = new Shelter();
        offer.setShelter(shelter);
        assertEquals(shelter, offer.getShelter());
    }

    @Test
    public void testAdopterGetterAndSetter() {
        AdoptionOfferJSON offer = new AdoptionOfferJSON();
        Adopter adopter = new Adopter();
        offer.setAdopter(adopter);
        assertEquals(adopter, offer.getAdopter());
    }

    @Test
    public void testAdoptionTermsGetterAndSetter() {
        AdoptionOfferJSON offer = new AdoptionOfferJSON();
        offer.setAdoptionTerms("Terms and conditions");
        assertEquals("Terms and conditions", offer.getAdoptionTerms());
    }

    // Add more tests as needed for specific functionalities or relationships
}
