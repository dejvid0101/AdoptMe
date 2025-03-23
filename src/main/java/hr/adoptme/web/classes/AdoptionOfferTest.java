package hr.adoptme.web.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdoptionOfferTest {

    /*@Test
    public void testAdoptionOfferInitialization() {
        AdoptionOffer offer = new AdoptionOffer();
        assertNull(offer.getId());
        assertNull(offer.getPetId());
        assertNull(offer.getShelterId());
        assertNull(offer.getAdopterId());
        assertNull(offer.getAdoptionTerms());
    }

    @Test
    public void testPetIdGetterAndSetter() {
        AdoptionOffer offer = new AdoptionOffer();
        offer.setPet(new Pet());
        assertNotNull(offer.getPetId());
    }*/

    /*@Test
    public void testShelterIdGetterAndSetter() {
        AdoptionOffer offer = new AdoptionOffer();
        offer.setShelter(new Shelter());
        assertNotNull(offer.getShelterId());
    }

    @Test
    public void testAdopterIdGetterAndSetter() {
        AdoptionOffer offer = new AdoptionOffer();
        offer.setAdopter(new Adopter());
        assertNotNull(offer.getAdopterId());
    }*/

    @Test
    public void testAdoptionTermsGetterAndSetter() {
        AdoptionOffer offer = new AdoptionOffer();
        offer.setAdoptionTerms("Terms and conditions");
        assertEquals("Terms and conditions", offer.getAdoptionTerms());
    }

    // Add more tests as needed for specific functionalities or relationships
}
