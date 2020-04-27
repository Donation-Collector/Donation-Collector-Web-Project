package com.example.dc.ngo;

import com.example.dc.model.NGO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NGOService {

	@Autowired
	private NGORepository ngoRepository;
	
	public boolean addNGO(NGO ngo) {
		List<NGO> ngos = getAllNGOs();
		for (NGO curr : ngos) {
			if (curr.getName().equals(ngo.getName())) {
				return false;
			}
		}
		ngoRepository.save(ngo);
		return true;
	}
	
	public List<NGO> getAllNGOs() {
		List<NGO> ngos = new ArrayList<>();
		ngoRepository.findAll().forEach(ngos::add);
		return ngos;
	}
	
//	public NGO getNGO(String name, String password) {
//		NGO ngo = ngoRepository.findById(name).orElse(null);
//		// if the ngo is not in the database or the password doesn't match, return null
//		if (ngo == null || !password.equals(ngo.getPassword())) {
//			return null;
//		}
//		return ngo;
//	}

	public NGO getNGO(String name, String password) {
		List<NGO> ngos = getAllNGOs();
		for (NGO ngo : ngos) {
			if (ngo.getName().equals(name) && ngo.getPassword().equals(password)) {
				return ngo;
			}
		}
		return null;
	}

}