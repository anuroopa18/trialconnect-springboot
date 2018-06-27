package webdev.TrialConnect.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webdev.TrialConnect.models.Allergy;
import webdev.TrialConnect.repositories.AllergyRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AllergyService {

	@Autowired
	AllergyRepository allergyRepository;

	@PostMapping("/api/allergy")
	public Allergy createAllergy(@RequestBody Allergy allergy) {
		return allergyRepository.save(allergy);
	}

	@GetMapping("/api/allergies")
	public List<Allergy> findAllAllergies() {
		return (List<Allergy>) allergyRepository.findAll();
	}

	@GetMapping("/api/allergy/{id}")
	public Allergy findAllergyById(@PathVariable("id") int aid) {
		Allergy all = new Allergy();
		Optional<Allergy> data = allergyRepository.findById(aid);
		if (data.isPresent()) {
			return data.get();
		}
		return all;
	}

	@DeleteMapping("/api/allergy/{id}")
	public void deleteAllergy(@PathVariable("id") int aid) {
		allergyRepository.deleteById(aid);
	}

	@PutMapping("/api/allergy/{id}")
	public Allergy updateAllergy(@PathVariable("id") int aid, @RequestBody Allergy newAllergy) {
		Allergy all = new Allergy();
		Optional<Allergy> data = allergyRepository.findById(aid);
		if (data.isPresent()) {
			Allergy allergy = data.get();
			if (newAllergy.getAllergen() != null && !newAllergy.getAllergen().equals("")) {
				allergy.setAllergen(newAllergy.getAllergen());
			}
			if (newAllergy.getEffect() != null && !newAllergy.getEffect().equals("")) {
				allergy.setEffect(newAllergy.getEffect());
			}
			if (newAllergy.getTreatment() != null) {
				allergy.setTreatment(newAllergy.getTreatment());
			}
			if (newAllergy.getName() != null && !newAllergy.getName().equals("")) {
				allergy.setName(newAllergy.getName());
			}

			return newAllergy;
		}
		return all;
	}

}
