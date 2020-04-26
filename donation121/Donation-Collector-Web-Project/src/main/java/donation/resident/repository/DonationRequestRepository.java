package donation.resident.repository;

import donation.resident.model.DonationRequest;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DonationRequestRepository extends CrudRepository<DonationRequest, Integer> {
}
