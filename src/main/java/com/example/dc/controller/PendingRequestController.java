package com.example.dc.controller;

import com.example.dc.model.DonationRequest;
import com.example.dc.service.PendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PendingRequestController {
    @Autowired
    PendingRequestService pendingRequestService;

    @RequestMapping("/pendingRequest/{NGOId}")
    public List<DonationRequest> getTopic(@PathVariable Long NGOId) {
        return pendingRequestService.getRequest(NGOId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/acceptRequest/{NGOId}")
    public boolean pendingRequest(@RequestBody List<Long> requestIds, @PathVariable Long NGOId) {
        return pendingRequestService.updateRequest(requestIds, NGOId);
    }
}
