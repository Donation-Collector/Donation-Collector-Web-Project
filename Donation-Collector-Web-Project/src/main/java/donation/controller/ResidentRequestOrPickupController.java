package donation.controller;


import donation.InputOutput.PickupInput;
import donation.model.Item;
import donation.model.NGO;
import donation.service.ResidentRequestOrPickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Step 1: Resident request pick up
 */
@RestController
@RequestMapping("/wecare")
public class ResidentRequestOrPickupController {
    @Autowired
    private ResidentRequestOrPickupService residentRequestOrPickupService;

    /**
     * get NGO base on zipcode
     *
     * @return
     */
    @GetMapping("/dropoff/{zipcode}")
    public List<NGO> dropoff(@PathVariable("zipcode") String zipcode) {
        return residentRequestOrPickupService.dropoff(zipcode);
    }

   /* @GetMapping("/pickup")
    public List<Item> getitem(@RequestParam("req")Integer req) {
        Map map = new HashMap();
        map.put("req",req);
//        map.put("quantity",quantity);
        return residentRequestOrPickupService.getitem(map);
    }*/

    @PostMapping("/pickup")
    public String pickup(@RequestBody PickupInput input) {
        return residentRequestOrPickupService.pickup(input);
    }
}
