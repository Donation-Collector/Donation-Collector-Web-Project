package com.example.dc.controller;

import com.example.dc.dto.DropOffDto;
import com.example.dc.model.NGO;
import com.example.dc.service.DropoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DropoffController {
    @Autowired
    private DropoffService dropoffService;

    /**
     * get NGO base on zipcode
     *
     * @return
     */
    @GetMapping("/dropoff/{zipcode}")
    public List<DropOffDto> dropoff(@PathVariable("zipcode") String zipcode) {

        return dropoffService.getDropoffs(zipcode);
    }
}
