package hr.adoptme.web.data_objects;

public class AdoptionOfferDTO {
        private Long petId;
        private Long shelterId;
        private Long adopterId;
        private String adoptionTerms;

        // Getters and Setters
        public Long getPetId() { return petId; }
        public void setPetId(Long petId) { this.petId = petId; }

        public Long getShelterId() { return shelterId; }
        public void setShelterId(Long shelterId) { this.shelterId = shelterId; }

        public Long getAdopterId() { return adopterId; }
        public void setAdopterId(Long adopterId) { this.adopterId = adopterId; }

        public String getAdoptionTerms() { return adoptionTerms; }
        public void setAdoptionTerms(String adoptionTerms) { this.adoptionTerms = adoptionTerms; }
}
