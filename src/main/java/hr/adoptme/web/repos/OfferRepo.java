package hr.adoptme.web.repos;

import hr.adoptme.web.classes.AdoptionOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepo extends JpaRepository<AdoptionOffer, Long> {

}
