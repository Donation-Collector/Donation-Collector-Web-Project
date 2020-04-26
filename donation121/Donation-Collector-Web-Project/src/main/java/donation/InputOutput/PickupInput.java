package donation.InputOutput;

import donation.model.Address;
import donation.model.DonationRequest;
import donation.model.Item;
import donation.model.NGO;
import lombok.Data;

import java.util.List;

@Data
public class PickupInput {

    private List<Item> items;

    private Address address;

    private DonationRequest donationRequest;

    private NGO ngo;
}
