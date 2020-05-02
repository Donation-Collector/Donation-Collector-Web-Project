package com.example.dc.service;

import com.example.dc.External.ZipCodeDistance;
import com.example.dc.dto.DropOffDto;
import com.example.dc.dto.NGODto;
import com.example.dc.model.DonationRequest;
import com.example.dc.model.Item;
import com.example.dc.model.NGO;
import com.example.dc.model.PickupInput;
import com.example.dc.ngo.NGORepository;
import com.example.dc.repository.AddressRepository;
import com.example.dc.repository.ItemRepository;
import com.example.dc.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PickupService {
    @Autowired
    private NGORepository ngoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RequestRepository donationRequestRepository;

//    public Map getitem() {
//        Map result = new HashMap();
//        List<Item> items = new ArrayList<>();
//        String[] array = new String[]{"book", "clothes", "furnitures", "toys", "others"};
//        for (int i = 0; i < array.length; i++) {
//            Item item = new Item();
//            item.setQuantity(0);
//            item.setType(array[i]);
//            items.add(item);
//        }
//        result.put("items", items);
//        List<NGO> ngos = (List<NGO>) ngoRepository.findAll();
//        result.put("ngos", ngos);
//        return result;
//    }

    public Iterable<NGODto> showNGOInRange(int zipCode) {
        Iterable<NGO> ngos = ngoRepository.findAll();
        List<NGODto> list = new ArrayList<>();
        for(NGO ngo : ngos) {
            int distance = ZipCodeDistance.getDistance(Integer.parseInt(ngo.getAddress().getZipcode()), zipCode);
            if (distance < Integer.parseInt(ngo.getCoverArea())) {
                list.add(NGODto.builder()
                        .name(ngo.getName())
                        .phoneNum(ngo.getPhoneNum())
                        .email(ngo.getEmail())
                        .description((ngo.getDescription()))
                        .distance(distance)
                        .build());
            }
        }

        return list;
    }

    @Transactional
    public String pickup(PickupInput input) {
        if (input.getAddress() == null) {
            return "address is null";
        }

        DonationRequest request = input.getDonationRequest();
        if (request != null) {
            request.setNgo(ngoRepository.findNGOByName(input.getNgoName()));
            request.setAddress(input.getAddress());
            request.setStatus("pending");
            donationRequestRepository.save(input.getDonationRequest());
        } else {
            return "donationRequest is null";
        }

        List<Item> items = input.getItems();
        if (items != null && !items.isEmpty()) {
            items.stream().forEach(e -> {
                e.setDonationRequest(request);
            });
        } else {
            return "items is empty";
        }

        itemRepository.saveAll(input.getItems());
        return "success";
    }
}
