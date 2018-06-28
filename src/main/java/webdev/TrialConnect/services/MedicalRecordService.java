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

import webdev.TrialConnect.models.MedicalRecord;
import webdev.TrialConnect.models.Patient;
import webdev.TrialConnect.repositories.MedicalRecordRepository;
import webdev.TrialConnect.repositories.PatientRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MedicalRecordService {

	@Autowired
	MedicalRecordRepository medicalRepository;

	@Autowired
	PatientRepository patientRepository;

	@PostMapping("/api/medicalrecord/{pid}")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord, @PathVariable("pid") int pid) {
		Optional<Patient> data = patientRepository.findById(pid);
		if (data.isPresent()) {
			Patient pat = data.get();
			medicalRecord.setPatient(pat);
			return medicalRepository.save(medicalRecord);
		}
		return new MedicalRecord();

	}

	@GetMapping("/api/medicalrecords")
	public List<MedicalRecord> findAllMedicalRecords() {
		return (List<MedicalRecord>) medicalRepository.findAll();
	}

	@GetMapping("/api/medicalrecord/{id}")
	public MedicalRecord findMedicalRecordById(@PathVariable("id") int mid) {
		MedicalRecord medicalRecord = new MedicalRecord();
		Optional<MedicalRecord> data = medicalRepository.findById(mid);
		if (data.isPresent()) {
			return data.get();
		}
		return medicalRecord;
	}

	@DeleteMapping("/api/medicalrecord/{id}")
	public void deleteMedicalRecord(@PathVariable("id") int mid) {
		medicalRepository.deleteById(mid);
	}

	@PutMapping("/api/medicalrecord/{id}")
	public MedicalRecord updateMedicalRecord(@PathVariable("id") int did, @RequestBody MedicalRecord newMedicalRecord) {
		MedicalRecord mr = new MedicalRecord();
		Optional<MedicalRecord> data = medicalRepository.findById(did);
		if (data.isPresent()) {
			MedicalRecord medicalRecord = data.get();
			if (newMedicalRecord.getAllergies() != null) {
				medicalRecord.setAllergies(newMedicalRecord.getAllergies());
			}

			if (newMedicalRecord.getMedicine() != null && !newMedicalRecord.getMedicine().equals("")) {
				medicalRecord.setMedicine(newMedicalRecord.getMedicine());
			}

			if (newMedicalRecord.getPatient() != null) {
				medicalRecord.setPatient(newMedicalRecord.getPatient());
			}
			if (newMedicalRecord.getDoctor() != null) {
				medicalRecord.setDoctor(newMedicalRecord.getDoctor());
			}
			if (newMedicalRecord.getVitals() != null) {
				medicalRecord.setVitals(newMedicalRecord.getVitals());
			}

			return newMedicalRecord;
		}
		return mr;
	}

}
