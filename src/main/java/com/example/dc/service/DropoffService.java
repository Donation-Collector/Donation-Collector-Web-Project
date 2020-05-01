package com.example.dc.service;


import com.example.dc.External.ZipCodeDistance;
import com.example.dc.dto.DropOffDto;
import com.example.dc.model.NGO;
import com.example.dc.ngo.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DropoffService {
    @Autowired
    private NGORepository ngoRepository;

    public List<DropOffDto> getDropoffs(String zipcode) {
        List<DropOffDto> list = new ArrayList<>();
        Iterable<NGO> ngos = ngoRepository.findAll();
        for(NGO ngo : ngos) {
            int distance = ZipCodeDistance.getDistance(Integer.parseInt(ngo.getAddress().getZipcode()), Integer.parseInt(zipcode));
            if (distance < 60) {
                list.add(DropOffDto.builder()
                        .name(ngo.getName())
                        .phoneNum(ngo.getPhoneNum())
                        .email(ngo.getEmail())
                        .address((ngo.getAddress()))
                        .distance(distance)
                        .build());
            }
        }

        Collections.sort(list, (n1, n2) -> n1.getDistance() - n2.getDistance());
        return list;
    }
}
