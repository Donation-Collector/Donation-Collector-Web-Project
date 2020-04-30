package com.example.dc.service;

import com.example.dc.model.DonationRequest;
import com.example.dc.model.DonationRequestWithItem;
import com.example.dc.model.Item;
import com.example.dc.model.ItemSimple;
import com.example.dc.repository.ItemRepository;
import com.example.dc.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
   @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private GetItems getItems;

    public List<DonationRequestWithItem> getRequest(Long NGOId) {
        List<DonationRequest> requests = new ArrayList<>();
        requestRepository.findByStatusAndNgoId("completed", NGOId).forEach(requests :: add);
        return getItems.getItem(requests);
    }
}
