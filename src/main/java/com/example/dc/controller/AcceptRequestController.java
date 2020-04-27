package com.example.dc.controller;

import com.example.dc.model.DonationRequest;
import com.example.dc.service.AcceptRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcceptRequestController {
    @Autowired
    AcceptRequestService acceptRequestService;

    @RequestMapping("/acceptRequest/{NGOId}")
    public List<DonationRequest> getTopic(@PathVariable Long NGOId) {
        return acceptRequestService.getRequest(NGOId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/acceptRequest/{NGOId}")
    public boolean acceptRequest(@RequestBody List<Long> requestIds, @PathVariable Long NGOId) {
        return acceptRequestService.updateRequest(requestIds, NGOId);
    }
}
