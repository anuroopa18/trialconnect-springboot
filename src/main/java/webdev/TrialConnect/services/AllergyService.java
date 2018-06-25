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
@CrossOrigin(origins="*",maxAge=3600)
public class AllergyService {
	
	@Autowired
	AllergyRepository allergyRepository;
	
	@PostMapping("/api/allergy")
	public Allergy createAllergy(@RequestBody Allergy allergy) {
		return allergyRepository.save(allergy);
	}
	
	@GetMapping("/api/allergies")
	public List<Allergy> findAllAllergies(){
		return (List<Allergy>) allergyRepository.findAll();
	}
	
	@GetMapping("/api/allergy/{id}")
	public Allergy findAllergyById(@PathVariable("id") int aid) {
		Optional<Allergy> data = allergyRepository.findById(aid);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@DeleteMapping("/api/allergy/{id}")
	public void deleteAllergy(@PathVariable("id") int aid)
	{
		allergyRepository.deleteById(aid);
	}
	
	@PutMapping("/api/allergy/{id}")
	public Allergy updateAllergy(@PathVariable("id") int aid, @RequestBody Allergy newAllergy) {
		Optional<Allergy> data = allergyRepository.findById(aid);
		if(data.isPresent()) {
			Allergy allergy = data.get();
			if(newAllergy.getDescription() != null && !newAllergy.getDescription().equals("") ) {
				allergy.setDescription(newAllergy.getDescription());
			}
			if(newAllergy.getCause() != null && !newAllergy.getCause().equals("") ) {
				allergy.setCause(newAllergy.getCause());
			}
			if(newAllergy.getAllergyType() != null) {
				allergy.setAllergyType(newAllergy.getAllergyType());
			}
			if(newAllergy.getMedicalRecord() != null ) {
				allergy.setMedicalRecord(newAllergy.getMedicalRecord());
			}
			if(newAllergy.getTreatment() != null && !newAllergy.getTreatment().equals("") ) {
				allergy.setTreatment(newAllergy.getTreatment());
			}
			
			return newAllergy;
		}
		return null;
	}
	

}
