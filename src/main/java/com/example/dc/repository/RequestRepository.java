package com.example.dc.repository;

import com.example.dc.model.DonationRequest;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RequestRepository extends CrudRepository<DonationRequest, Long> {
    List<DonationRequest> findByStatusAndNgoId(String status, Long NgoId);
}
