package com.example.dc.controller;

import com.example.dc.model.DonationRequestWithItem;
import com.example.dc.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @RequestMapping("/history/{NGOId}")
    public List<DonationRequestWithItem> getTopic(@PathVariable Long NGOId) {
        return historyService.getRequest(NGOId);
    }
}
