package hr.adoptme.web.services;

import hr.adoptme.web.classes.AdoptionOffer;
import hr.adoptme.web.repos.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferSvc {

    @Autowired
    private OfferRepo offerRepo;

    public Optional<AdoptionOffer> findOfferById(Long id) {
        return offerRepo.findById(id);
    }

    public List<AdoptionOffer> findAllOffers() {
        return offerRepo.findAll();
    }

    public AdoptionOffer saveOffer(AdoptionOffer offer) {
        return offerRepo.save(offer);
    }

    public void deleteOffer(Long id) {
        offerRepo.deleteById(id);
    }
}

