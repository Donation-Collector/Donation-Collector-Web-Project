package donation.repository;

import donation.model.NGO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NGORepository extends CrudRepository<NGO, Integer> {
    @Query(value = "select ngo.* from  ngo left join address addr on addr.id = ngo.address_id where addr.zipcode = ?1", nativeQuery = true)
    List<NGO> getNGOByZipcode(String zipcode);
}
