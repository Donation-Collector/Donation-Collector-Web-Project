package com.example.dc.service;

import com.example.dc.controller.SendEmail;
import com.example.dc.model.*;
import com.example.dc.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PendingRequestService {
   @Autowired
    private RequestRepository requestRepository;

   @Autowired
   private GetItems getItems;
   @Autowired
   private SendEmail sendEmail;

    public List<DonationRequestWithItem> getRequest(Long NGOId) {
        List<DonationRequest> requests = new ArrayList<>();
        requestRepository.findByStatusAndNgoId("pending", NGOId).forEach(requests :: add);
        return getItems.getItem(requests);
    }

    public boolean updateRequest(List<IdOfRequest> requestIds, Long NGOId) throws Exception {
        List<Long> requestIdLong = new ArrayList<>();
        for (IdOfRequest requestId : requestIds) {
            requestIdLong.add(requestId.getId());
        }
        List<DonationRequest> requests = (List<DonationRequest>) requestRepository.findAllById(requestIdLong);
        for (DonationRequest request : requests) {
            if (request.getStatus().equals("accepted")) {
                return false;
            }
            request.setStatus("accepted");
            requestRepository.save(request);
            sendEmail.main(request.getEmail(), "accepted");
        }
        return true;
    }
}
