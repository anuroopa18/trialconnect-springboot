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

import webdev.TrialConnect.models.Vaccine;
import webdev.TrialConnect.repositories.VaccineRepository;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class VaccineService {

	@Autowired
	VaccineRepository vaccineRepository;
	
	@PostMapping("/api/vaccine")
	public Vaccine createVaccine(@RequestBody Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}
	
	@GetMapping("/api/vaccines")
	public List<Vaccine> findAllVaccines(){
		return (List<Vaccine>) vaccineRepository.findAll();
	}
	
	@GetMapping("/api/vaccine/{id}")
	public Vaccine findVaccineById(@PathVariable("id") int vid) {
		Optional<Vaccine> data = vaccineRepository.findById(vid);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@DeleteMapping("/api/vaccine/{id}")
	public void deleteVaccine(@PathVariable("id") int vid)
	{
		vaccineRepository.deleteById(vid);
	}
	
	@PutMapping("/api/vaccine/{id}")
	public Vaccine updateVaccine(@PathVariable("id") int vid, @RequestBody Vaccine newVaccine ){
		Optional<Vaccine> data = vaccineRepository.findById(vid);
		if(data.isPresent()) {
			Vaccine vaccine = data.get();
			if(newVaccine.getMedicalRecord()!= null) {
				vaccine.setMedicalRecord(newVaccine.getMedicalRecord());
			}
			if(newVaccine.getBrand()!= null && !newVaccine.getBrand().equals("") ) {
				vaccine.setBrand(newVaccine.getBrand());
			}
			if(newVaccine.getDateOfAdministration()!= null ) {
				vaccine.setDateOfAdministration(newVaccine.getDateOfAdministration());
			}
			if(newVaccine.getName()!= null && !newVaccine.getName().equals("")  ) {
				vaccine.setName(newVaccine.getName());
			}
			if(newVaccine.getDoses()!= 0) {
				vaccine.setDoses(newVaccine.getDoses());
			}
			
			
			return newVaccine;
		}
		return null;
	}
	
}
