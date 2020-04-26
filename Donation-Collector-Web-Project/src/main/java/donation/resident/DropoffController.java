package donation.resident;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wecare")
public class DropoffController {
    @Autowired
    private DropoffService dropoffService;

    /**
     * get NGO base on zipcode
     *
     * @return
     */
    @GetMapping("/dropoff/{zipcode}")
    public List<NGO> dropoff(@PathVariable("zipcode") String zipcode) {
        return dropoffService.dropoff(zipcode);
    }
}
