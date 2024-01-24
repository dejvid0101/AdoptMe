package hr.adoptme.web.services;

import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.repos.PetRepo;
import hr.adoptme.web.services.PetSvc;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PetSvcTest {

    @Mock
    private PetRepo petRepo;

    @InjectMocks
    private PetSvc petSvc;

    @Test
    public void testFindPetById() {
        // Arrange
        Pet expectedPet = new Pet();
        expectedPet.id=1L;

        when(petRepo.findById(1L)).thenReturn(Optional.of(expectedPet));

        // Act
        Optional<Pet> result = petSvc.findPetById(1L);

        // Assert
        assertEquals(expectedPet, result.orElse(null));
        verify(petRepo, times(1)).findById(1L);
    }

    // Add more tests as needed for other service methods
}
