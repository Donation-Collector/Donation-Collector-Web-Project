package donation.resident.service.impl;

import donation.resident.model.Item;
import donation.resident.model.NGO;
import donation.resident.model.PickupInput;
import donation.resident.repository.AddressRepository;
import donation.resident.repository.DonationRequestRepository;
import donation.resident.repository.ItemRepository;
import donation.resident.repository.NGORepository;
import donation.resident.service.PickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PickupServiceImpl implements PickupService {
    @Autowired
    private NGORepository ngoRepository;

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DonationRequestRepository donationRequestRepository;

    @Override
    public Map getitem() {
        Map result = new HashMap();
        List<Item> items = new ArrayList<>();
        String[] array = new String[]{"book", "clothes", "furnitures", "toys", "others"};
        for (int i = 0; i < array.length; i++) {
            Item item = new Item();
            item.setQuantity(0);
            item.setType(array[i]);
            items.add(item);
        }
        result.put("items", items);
        List<NGO> ngos = (List<NGO>) ngoRepository.findAll();
        result.put("ngos", ngos);
        return result;
    }

    @Override
    @Transactional
    public String pickup(PickupInput input) {
        if (input.getAddress() != null) {
            addressRepository.save(input.getAddress());
        } else {
            return "address is null";
        }
        if (input.getDonationRequest() != null) {
            input.getDonationRequest().setNgo(input.getNgo());
            input.getDonationRequest().setAddress(input.getAddress());
            donationRequestRepository.save(input.getDonationRequest());
        } else {
            return "donationRequest is null";
        }
        List<Item> items = input.getItems();
        if (items != null && !items.isEmpty()) {
            items.stream().forEach(e -> {
                e.setDonationRequest(input.getDonationRequest());
            });
        } else {
            return "items is empty";
        }
        itemRepository.saveAll(input.getItems());
        return "success";
    }
}
