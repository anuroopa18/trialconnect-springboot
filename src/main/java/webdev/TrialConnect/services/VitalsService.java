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

import webdev.TrialConnect.models.Vitals;
import webdev.TrialConnect.repositories.VitalsRepository;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class VitalsService {
	
	@Autowired
	VitalsRepository vitalsRepository;
	
	@PostMapping("/api/vitals")
	public Vitals createVitals(@RequestBody Vitals vitals) {
		return vitalsRepository.save(vitals);
	}
	
	@GetMapping("/api/vitals")
	public List<Vitals> findAllVitals(){
		return (List<Vitals>) vitalsRepository.findAll();
	}
	
	@GetMapping("/api/vitals/{id}")
	public Vitals findVitalsById(@PathVariable("id") int vid) {
		Vitals vt = new Vitals();
		Optional<Vitals> data = vitalsRepository.findById(vid);
		if(data.isPresent()) {
			return data.get();
		}
		return vt;	
	}
	
	@DeleteMapping("/api/vitals/{id}")
	public void deleteVitals(@PathVariable("id") int vid)
	{
		vitalsRepository.deleteById(vid);
	}
	
	@PutMapping("/api/vitals/{id}")
	public Vitals updateVitals(@PathVariable("id") int vid, @RequestBody Vitals newVitals ){
		Vitals vt = new Vitals();
		Optional<Vitals> data = vitalsRepository.findById(vid);
		if(data.isPresent()) {
			Vitals vitals = data.get();
			if(newVitals.getBloodPressure()!= null && !newVitals.getBloodPressure().equals("")) {
				vitals.setBloodPressure(newVitals.getBloodPressure());
			}
			if(newVitals.getBodyTemperature()!= null && !newVitals.getBodyTemperature().equals("") ) {
				vitals.setBodyTemperature(newVitals.getBodyTemperature());
			}
			if(newVitals.getPulseRate()!= null && !newVitals.getPulseRate().equals("") ) {
				vitals.setPulseRate(newVitals.getPulseRate());
			}
			if(newVitals.getMedicalRecord()!= null ) {
				vitals.setMedicalRecord(newVitals.getMedicalRecord());
			}
		
			return newVitals;
		}
		return vt;
	}

}
