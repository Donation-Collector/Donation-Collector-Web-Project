package donation.service.impl;


import donation.InputOutput.PickupInput;
import donation.model.Item;
import donation.model.NGO;
import donation.repository.AddressRepository;
import donation.repository.DonationRequestRepository;
import donation.repository.ItemRepository;
import donation.repository.NGORepository;
import donation.service.ResidentRequestOrPickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ResidentRequestOrPickupServiceImpl implements ResidentRequestOrPickupService {
    @Autowired
    private NGORepository ngoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DonationRequestRepository donationRequestRepository;
    @Override
    public List<NGO> dropoff(String zipcode) {
        List<NGO> ngos = ngoRepository.getNGOByZipcode(zipcode);
        return ngos;
    }

    @Override
    public List<Item> getitem(Map map) {
        List<Item> items = itemRepository.getItemByReq((Integer)map.get("req"));
        return items;
    }


    @Override
    @Transactional
    public String pickup(PickupInput input) {
        if(input.getAddress() != null){
            addressRepository.save(input.getAddress());
        }else{
            return "address is null";
        }
        if(input.getDonationRequest() != null){
            input.getDonationRequest().setNgo(input.getNgo());
            input.getDonationRequest().setAddress(input.getAddress());
            donationRequestRepository.save(input.getDonationRequest());
        }else {
            return "donationRequest is null";
        }
        List<Item> items = input.getItems();
        if(items != null && !items.isEmpty()){
            items.stream().forEach(e->{
                e.setDonationRequest(input.getDonationRequest());
            });
        }else {
            return "items is empty";
        }
        itemRepository.saveAll(input.getItems());
        return "success";
    }
}
