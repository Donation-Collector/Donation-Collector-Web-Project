package com.example.dc.demo;

import com.example.dc.model.Address;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DemoRepository extends CrudRepository<Address, Integer> {

}
