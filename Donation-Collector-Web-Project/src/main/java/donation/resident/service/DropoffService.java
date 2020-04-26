package donation.resident.service;

import donation.resident.model.NGO;

import java.util.List;

public interface DropoffService {
    List<NGO> dropoff(String zipcode);
}
