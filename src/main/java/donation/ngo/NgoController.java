package donation.ngo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NgoController {

	@Autowired
	private NgoService ngoService;
	
	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public boolean addUser(@RequestBody Ngo ngo) {
		return ngoService.addNgo(ngo);
	}
	
	@RequestMapping("/hello")
	public String test() {
		return "hello";
	}
	
}