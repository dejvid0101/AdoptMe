package hr.adoptme.web.repos;

import hr.adoptme.web.WebCtrlr;
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
public class PetRepoTest {

    @Mock
    private PetRepo petRepo;

    @InjectMocks
    private PetSvc petSvc;

    /*@Test
    public void testFindById() {
        // Arrange
        Pet expectedPet = new Pet();
        expectedPet.id = 1L;

        when(petRepo.findById(1L)).thenReturn(Optional.of(expectedPet));

        // Act
        Optional<Pet> result = petSvc.findPetById(expectedPet.id);

        // Assert
        assertEquals(expectedPet, result.orElse(null));
        verify(petRepo, times(1)).findById(1L);
    }*/
}