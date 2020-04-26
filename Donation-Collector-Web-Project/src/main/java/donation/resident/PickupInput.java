package donation.resident;

import lombok.Data;

import java.util.List;

@Data
public class PickupInput {

    private List<Item> items;

    private Address address;

    private DonationRequest donationRequest;

    private NGO ngo;
}
