package com.example.dc.repository;

import com.example.dc.model.DonationRequest;
import com.example.dc.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByDonationRequestId(Long donationRequestId);
    @Query(value = "select item.* from item item " +
            "left join donation_request dr on dr.id = item.request_id " +
            "left join ngo ngo on ngo.id = dr.ngo_id " +
            "where dr.id=?1", nativeQuery = true)
    List<Item> getItemByReq(Long req);

    @Transactional
    void deleteByDonationRequest(DonationRequest request);
}
