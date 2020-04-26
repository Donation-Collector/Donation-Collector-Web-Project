package donation.resident.pickup;


import donation.resident.model.Item;
import donation.resident.model.PickupInput;
import donation.resident.service.PickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wecare")
public class PickupController {
    @Autowired
    private PickupService pickupService;

    /**
     * input:pickup request
     * output:
     *      List item:book, clothes, furnitures, toys,others(miscellaneous)
     * ,the initial number of the item, the ngo list
     * @param
     * @return
     */
    @GetMapping("/pickup")
    public Map getitem() {

        return pickupService.getitem();
    }

    /**
     *input: the number of the list item people want to donate. The NGO residents prefer.
     * resident information: name; address, city, state, email, tel, zip code..
     * @param input
     * @return
     */
    @PostMapping("/pickup")
    public String pickup(@RequestBody PickupInput input) {
        return pickupService.pickup(input);
    }
}
