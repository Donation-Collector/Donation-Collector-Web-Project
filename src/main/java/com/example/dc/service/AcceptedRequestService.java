package com.example.dc.service;

import com.example.dc.model.DonationRequest;
import com.example.dc.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcceptedRequestService {
    @Autowired
    private RequestRepository requestRepository;

    public List<DonationRequest> getRequest(Long NGOId) {
        List<DonationRequest> requests = new ArrayList<>();
        requestRepository.findByStatusAndNgoId("accepted", NGOId).forEach(requests :: add);
        return requests;
    }

    public boolean updateRequest(List<Long> requestIds, Long NGOId) {
        List<DonationRequest> requests = (List<DonationRequest>) requestRepository.findAllById(requestIds);
        for (DonationRequest request : requests) {
            request.setStatus("completed");
            requestRepository.save(request);
        }
        return true;
    }
}
