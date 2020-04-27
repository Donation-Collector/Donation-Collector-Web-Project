package com.example.dc.repository;

import com.example.dc.model.NGO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NGORepository extends CrudRepository<NGO, Long> {
}
