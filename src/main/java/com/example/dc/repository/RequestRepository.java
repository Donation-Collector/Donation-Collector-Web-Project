package com.example.dc.repository;

import com.example.dc.model.DonationRequest;
import com.example.dc.model.NGO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface RequestRepository extends CrudRepository<DonationRequest, Long> {
    //List<DonationRequest> findByNGOIdAndStatus(Long NGOId, String status);
    List<DonationRequest> findByStatusAndNgoId(String status, Long NgoId);
}
