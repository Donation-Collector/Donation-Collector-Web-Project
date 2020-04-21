package donation.ngo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NgoService {

	@Autowired
	private NgoRepository ngoRepository;
	
	public boolean addNgo(Ngo ngo) {
		List<Ngo> ngos = getAllNgos();
		for (Ngo curr : ngos) {
			if (curr.getName().equals(ngo.getName())) {
				return false;
			}
		}
		ngoRepository.save(ngo);
		return true;
	}
	
	public List<Ngo> getAllNgos() {
		List<Ngo> ngos = new ArrayList<>();
		ngoRepository.findAll().forEach(ngos::add);
		return ngos;
	}
}