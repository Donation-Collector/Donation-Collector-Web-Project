package donation.service;


import donation.InputOutput.PickupInput;
import donation.model.Item;
import donation.model.NGO;

import java.util.List;
import java.util.Map;

public interface ResidentRequestOrPickupService {
    List<NGO> dropoff(String zipcode);

    List<Item> getitem(Map map);

    String pickup(PickupInput input);
}
