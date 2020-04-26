package donation.resident.repository;

import donation.resident.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ItemRepository extends CrudRepository<Item, Integer> {
    @Query(value = "select item.* from item item " +
            "left join donation_request dr on dr.id = item.request_id " +
            "left join ngo ngo on ngo.id = dr.ngo_id " +
            "where dr.id=?1", nativeQuery = true)
    List<Item> getItemByReq(Integer req);
}
