package com.example.dc.service;


import com.example.dc.model.NGO;
import com.example.dc.ngo.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropoffService {
    @Autowired
    private NGORepository ngoRepository;

    public List<NGO> dropoff(String zipcode) {
        List<NGO> ngos = ngoRepository.getNGOByZipcode(zipcode);
        return ngos;
    }
}
