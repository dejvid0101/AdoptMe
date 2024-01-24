package hr.adoptme.web.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    @Test
    public void testPetInitialization() {
        Pet pet = new Pet();
        assertNull(pet.id);
        assertNull(pet.Name);
        assertEquals(0, pet.Age);
        assertNull(pet.Gender);
        assertNull(pet.Species);
        assertNull(pet.Shelter);
        assertNull(pet.Health);
        assertNull(pet.Availability);
    }


    // Add more tests as needed for specific functionalities or relationships
}
