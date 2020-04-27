package com.example.dc.ngo;

import com.example.dc.model.NGO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NGOController {

	@Autowired
	private NGOService ngoService;
	
	@RequestMapping("/registration")
	public List<NGO> getAllNGOs() {
		return ngoService.getAllNGOs();
	}

	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public boolean addNGO(@RequestBody NGO ngo) {
		return ngoService.addNGO(ngo);
	}
	
	// return if there's such ngo in the database with the same name and password
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public boolean login(@RequestBody User user) {
		NGO ngo = ngoService.getNGO(user.getName(), user.getPassword());
		return ngo != null;
	}
	
	@RequestMapping("/hello")
	public String test() {
		return "hello";
	}
	
}

class User {
	private String name;
	private String password;
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