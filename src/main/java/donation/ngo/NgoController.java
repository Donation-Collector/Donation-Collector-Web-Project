package donation.ngo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NgoController {

	@Autowired
	private NgoService ngoService;
	
	@RequestMapping("/registration")
	public List<Ngo> getAllNgos() {
		return ngoService.getAllNgos();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public boolean addNgo(@RequestBody Ngo ngo) {
		return ngoService.addNgo(ngo);
	}
	
	// return if there's such ngo in the database with the same name and password
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public boolean login(@RequestBody User user) {
		Ngo ngo = ngoService.getNgo(user.getName(), user.getPassword());
		return ngo == null ? false : true;
	}
	
	@RequestMapping("/hello")
	public String test() {
		return "hello";
	}
	
}

class User {
	String name;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}