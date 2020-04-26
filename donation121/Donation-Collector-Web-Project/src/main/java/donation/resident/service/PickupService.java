package donation.resident.service;

import donation.resident.model.Item;
import donation.resident.model.PickupInput;

import java.util.List;
import java.util.Map;

public interface PickupService {

    Map getitem();

    String pickup(PickupInput input);
}
