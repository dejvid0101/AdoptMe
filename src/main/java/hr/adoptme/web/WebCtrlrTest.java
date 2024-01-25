package hr.adoptme.web;

import static java.util.Optional.empty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Optional;

import hr.adoptme.web.classes.Adopter;
import hr.adoptme.web.classes.AdoptionOffer;
import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.classes.Shelter;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import hr.adoptme.web.repos.AdopterRepo;
import hr.adoptme.web.repos.OfferRepo;
import hr.adoptme.web.repos.PetRepo;
import hr.adoptme.web.repos.ShelterRepo;
import hr.adoptme.web.services.AdopterSvc;
import hr.adoptme.web.services.OfferSvc;
import hr.adoptme.web.services.PetSvc;
import hr.adoptme.web.services.ShelterSvc;
import org.aspectj.lang.annotation.Before;
import org.hibernate.internal.log.SubSystemLogging;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class WebCtrlrTest {

    @Mock
    private OfferSvc offerSvc;
    @Mock
    private AdopterSvc adopterSvc;

    @Mock
    private PetSvc petSvc;

    @Mock
    private ShelterSvc shelterSvc;

    @InjectMocks
    private WebCtrlr webController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(webController).build();
    }

    @Test
    public void testGetAdopter() throws Exception {
        // Arrange
        Long adopterId = 1L;
        Adopter adopter = new Adopter(adopterId, "Testni udomitelj", "udomi@me.com", "0987654321", "fefe");

        // Mocking the behavior of the repository
        when(adopterSvc.findAdopterById(anyLong())).thenReturn(Optional.of(adopter));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/getAdopter")
                        .param("id", String.valueOf(adopterId)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(adopterId))
                .andExpect(jsonPath("$.Name").value(adopter.Name))
                .andExpect(jsonPath("$.Email").value(adopter.Email));
    }

    @Test
    public void testGetPetById() throws Exception {
        // Arrange
        Long petId = 1L;
        Pet expectedPet = new Pet("Fifi", 3, Gender.MALE, "Mačka", new Shelter(), Health.HEALTHY, Availability.AVAILABLE);
        expectedPet.id = petId;
        when(petSvc.findPetById(anyLong())).thenReturn(Optional.of(expectedPet));

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/getPet").param("id", String.valueOf(petId)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(petId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Name").value(expectedPet.Name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Age").value(expectedPet.Age));

    }
    @Test
    public void testSaveOffer() {

        // Arrange
        String fakeJSONoffer = "{\"pet\":{\"id\":\"1\",\"Name\":\"Fluffy\",\"Age\":2,\"Gender\":\"FEMALE\","+
                "\"Species\":\"Cat\",\"Shelter\":\"Rescue Shelter\",\"Health\":\"HEALTHY\"},\"adopter\":{\"Name\":\"g\","+
                "\"Phone\":\"p\",\"Email\":\"dejvid0101@gmail.com\"},\"adoptionTerms\":\"M\"}";

        lenient().when(webController.savePet("Fifi")) // Make sure any pet exists before saving offer
                .thenAnswer(invocation -> {
                    mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/addOffer")
                                    .content(fakeJSONoffer)
                                    .contentType(("application/json")))
                            .andExpect(MockMvcResultMatchers.status().isOk());

                    // Verify that shelter, adopter, offer have been added and pet exists
                    verify(adopterSvc, times(1)).saveAdopter(any());
                    verify(shelterSvc, times(1)).saveShelter(any());
                    verify(petSvc, times(1)).findPetById(anyLong());
                    verify(offerSvc, times(1)).saveOffer(any());
                    return null;
                });
    }

}
