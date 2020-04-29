package com.example.dc.repository;

import com.example.dc.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Address, Long> {
}
