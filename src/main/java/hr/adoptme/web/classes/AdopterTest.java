package hr.adoptme.web.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdopterTest {

    @Test
    public void testAdopterInitialization() {
        Adopter adopter = new Adopter();
        assertNull(adopter.id);
        assertNull(adopter.Name);
        assertNull(adopter.Email);
        assertNull(adopter.Phone);
    }

    @Test
    public void testNameGetterAndSetter() {
        Adopter adopter = new Adopter();
        adopter.Name="John Doe";
        assertEquals("John Doe", adopter.Name);
    }

    @Test
    public void testEmailGetterAndSetter() {
        Adopter adopter = new Adopter();
        adopter.Email="john.doe@example.com";
        assertEquals("john.doe@example.com", adopter.Email);
    }

    @Test
    public void testPhoneGetterAndSetter() {
        Adopter adopter = new Adopter();
        adopter.Phone="123-456-7890";
        assertEquals("123-456-7890", adopter.Phone);
    }

    // Add more tests as needed for specific functionalities or relationships
}
