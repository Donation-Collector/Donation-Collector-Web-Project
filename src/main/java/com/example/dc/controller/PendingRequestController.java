package com.example.dc.controller;

import com.example.dc.model.DonationRequest;
import com.example.dc.model.DonationRequestWithItem;
import com.example.dc.model.IdOfRequest;
import com.example.dc.service.PendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PendingRequestController {
    @Autowired
    PendingRequestService pendingRequestService;

    @RequestMapping("/pendingRequest/{NGOId}")
    public List<DonationRequestWithItem> getTopic(@PathVariable Long NGOId) {

        return pendingRequestService.getRequest(NGOId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/pendingRequest/{NGOId}")
    public boolean acceptRequest(@RequestBody List<IdOfRequest> requestIds, @PathVariable Long NGOId) throws Exception {
        return pendingRequestService.updateRequest(requestIds, NGOId);
    }
}
