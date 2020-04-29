package com.example.dc.ngo;

import com.example.dc.model.NGO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NGORepository extends CrudRepository<NGO, String>{
    @Query(value = "select ngo.* from  ngo left join address addr on addr.id = ngo.address_id where addr.zipcode = ?1", nativeQuery = true)
    List<NGO> getNGOByZipcode(String zipcode);
}
