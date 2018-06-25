package webdev.TrialConnect.services;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webdev.TrialConnect.models.MedicalRecord;
import webdev.TrialConnect.repositories.MedicalRecordRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class MedicalRecordService {
	
	@Autowired
	MedicalRecordRepository medicalRepository;
	
	@PostMapping("/api/medicalrecord")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRepository.save(medicalRecord);
	}
	
	@GetMapping("/api/medicalrecords")
	public List<MedicalRecord> findAllMedicalRecords(){
		return (List<MedicalRecord>) medicalRepository.findAll();
	}
	
	@GetMapping("/api/medicalrecord/{id}")
	public MedicalRecord findMedicalRecordById(@PathVariable("id") int mid) {
		Optional<MedicalRecord> data = medicalRepository.findById(mid);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@DeleteMapping("/api/medicalrecord/{id}")
	public void deleteMedicalRecord(@PathVariable("id") int mid)
	{
		medicalRepository.deleteById(mid);
	}
	
	@PutMapping("/api/medicalrecord/{id}")
	public MedicalRecord updateMedicalRecord(@PathVariable("id") int did, @RequestBody MedicalRecord newMedicalRecord) {
		Optional<MedicalRecord> data = medicalRepository.findById(did);
		if(data.isPresent()) {
			MedicalRecord medicalRecord = data.get();
			if(newMedicalRecord.getAllergy()!= null) {
				medicalRecord.setAllergy(newMedicalRecord.getAllergy());
			}
			if(newMedicalRecord.getMedicine()!= null && !newMedicalRecord.getMedicine().equals("") ) {
				medicalRecord.setMedicine(newMedicalRecord.getMedicine());
			}
			if(newMedicalRecord.getGender()!= null && !newMedicalRecord.getGender().equals("") ) {
				medicalRecord.setGender(newMedicalRecord.getGender());
			}
			if(newMedicalRecord.getPatient()!= null) {
				medicalRecord.setPatient(newMedicalRecord.getPatient());
			}
			if(newMedicalRecord.getDoctor()!= null) {
				medicalRecord.setDoctor(newMedicalRecord.getDoctor());
			}
			if(newMedicalRecord.getProblems()!= null && !newMedicalRecord.getProblems().equals("") ) {
				medicalRecord.setProblems(newMedicalRecord.getProblems());
			}
			if(newMedicalRecord.getResults()!= null && !newMedicalRecord.getResults().equals("") ) {
				medicalRecord.setResults(newMedicalRecord.getResults());
			}
			if(newMedicalRecord.getVaccine()!= null ) {
				medicalRecord.setVaccine(newMedicalRecord.getVaccine());
			}
			if(newMedicalRecord.getVitals()!= null ) {
				medicalRecord.setVitals(newMedicalRecord.getVitals());
			}
			if(newMedicalRecord.getVisits()!= null ) {
				medicalRecord.setVisits(newMedicalRecord.getVisits());
			}
			
			return newMedicalRecord;
		}
		return null;
	}
	
	

}
