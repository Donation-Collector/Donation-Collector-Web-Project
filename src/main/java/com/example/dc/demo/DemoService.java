package com.example.dc.demo;

import com.example.dc.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public void addAddress(Address address) {
        demoRepository.save(address);
    }

    public Iterable<Address> findAllAddress() {
        return demoRepository.findAll();
    }
}
