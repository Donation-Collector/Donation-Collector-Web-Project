package donation.resident.service.impl;

import donation.resident.model.NGO;
import donation.resident.repository.NGORepository;
import donation.resident.service.DropoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropoffServiceImpl implements DropoffService {
    @Autowired
    private NGORepository ngoRepository;

    @Override
    public List<NGO> dropoff(String zipcode) {
        List<NGO> ngos = ngoRepository.getNGOByZipcode(zipcode);
        return ngos;
    }
}
