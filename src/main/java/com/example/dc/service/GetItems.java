package com.example.dc.service;

import com.example.dc.model.DonationRequest;
import com.example.dc.model.DonationRequestWithItem;
import com.example.dc.model.Item;
import com.example.dc.model.ItemSimple;
import com.example.dc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetItems {

    @Autowired
    private ItemRepository itemRepository;

    public List<DonationRequestWithItem> getItem(List<DonationRequest> requests) {
        List<DonationRequestWithItem> requestWithItems = new ArrayList<>();
        for (DonationRequest request : requests) {
            DonationRequestWithItem requestWithItem = new DonationRequestWithItem();
            requestWithItem.setId(request.getId());
            requestWithItem.setAddress(request.getAddress());
            requestWithItem.setEmail(request.getEmail());
            requestWithItem.setNotes(request.getNotes());
            requestWithItem.setStatus(request.getStatus());
            requestWithItem.setDate(request.getDate());
            requestWithItem.setNgo(request.getNgo());
            List<Item> itemList = new ArrayList<>();
            itemRepository.findByDonationRequestId(request.getId()).forEach(itemList :: add);
            List<ItemSimple> itemList1 = new ArrayList<>();
            for (Item item : itemList) {
                ItemSimple itemSimple = new ItemSimple();
                itemSimple.setType(item.getType());
                itemSimple.setQuantity(item.getQuantity());
                itemSimple.setDescription(item.getDescription());
                itemList1.add(itemSimple);
            }
            requestWithItem.setItems(itemList1);
            requestWithItems.add(requestWithItem);
        }

        return requestWithItems;
    }
}
