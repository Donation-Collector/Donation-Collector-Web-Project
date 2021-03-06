package com.example.dc.controller;

import com.example.dc.model.DonationRequestWithItem;
import com.example.dc.model.IdOfRequest;
import com.example.dc.service.AcceptedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcceptedRequestController {
    @Autowired
    AcceptedRequestService acceptedRequestService;

    @RequestMapping("/acceptedRequest/{NGOId}")
    public List<DonationRequestWithItem> getTopic(@PathVariable Long NGOId) {
        return acceptedRequestService.getRequest(NGOId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/acceptedRequest/{NGOId}")
    public boolean acceptRequest(@RequestBody List<IdOfRequest> requestIds, @PathVariable Long NGOId) throws Exception {
        return acceptedRequestService.updateRequest(requestIds, NGOId);
    }
}
