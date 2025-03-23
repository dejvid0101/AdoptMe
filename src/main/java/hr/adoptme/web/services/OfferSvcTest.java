package hr.adoptme.web.services;

import hr.adoptme.web.classes.Adopter;
import hr.adoptme.web.classes.AdoptionOffer;
import hr.adoptme.web.classes.Pet;
import hr.adoptme.web.classes.Shelter;
import hr.adoptme.web.enums.Availability;
import hr.adoptme.web.enums.Gender;
import hr.adoptme.web.enums.Health;
import hr.adoptme.web.repos.OfferRepo;
import hr.adoptme.web.services.OfferSvc;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OfferSvcTest {

    @Mock
    private OfferRepo offerRepo;

    @InjectMocks
    private OfferSvc offerSvc;

   /* @Test
    public void testSaveOffer() {

        AdoptionOffer offerToSave = new AdoptionOffer(
                new Pet("Fefe",6, Gender.FEMALE,"Kornjača", new Shelter(), Health.HEALTHY, Availability.AVAILABLE),
                new Shelter(),
                new Adopter(1L, "Fefe", "adopter@gmail.com","0987654321", ""),
                "Adoption terms");

        when(offerRepo.save(offerToSave)).thenReturn(offerToSave);

        AdoptionOffer savedOffer = offerSvc.saveOffer(offerToSave);

        assertEquals(offerToSave, savedOffer);
        verify(offerRepo, times(1)).save(offerToSave);
    }
*/
}
