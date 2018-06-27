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
import webdev.TrialConnect.models.Patient;
import webdev.TrialConnect.repositories.PatientRepository;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	@PostMapping("/api/patient")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	@GetMapping("/api/patients")
	public List<Patient> findAllPatients(){
		return (List<Patient>) patientRepository.findAll();
	}
	
	@GetMapping("/api/findPatient/{username}")
	public Patient findPatientByUsername(@PathVariable("username") String username) {
		Patient pat = new Patient();
		Optional<Patient> data = patientRepository.findUserByUsername(username);
		if(data.isPresent()) {
			return data.get();
		}
		return pat;
	}
	
	@PostMapping("/api/findPatientByCredentials/patient")
	public Patient findPatientByCredentials(@RequestBody Patient patient) {
		Patient pat = new Patient();
		Optional<Patient> data = patientRepository.findUserByCredentials(patient.getUsername(),patient.getPassword());
		if(data.isPresent()) {
			return data.get();
		}
		return pat;
	}
	
	@GetMapping("/api/patient/{id}")
	public Patient findPatientById(@PathVariable("id") int pid) {
		Optional<Patient> data = patientRepository.findById(pid);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@DeleteMapping("/api/patient/{id}")
	public void deletePatient(@PathVariable("id") int pid)
	{
		patientRepository.deleteById(pid);
	}
	
	@PutMapping("/api/patient/{id}")
	public Patient updatePatient(@PathVariable("id") int pid, @RequestBody Patient newPatient) {
		Optional<Patient> data = patientRepository.findById(pid);
		if(data.isPresent()) {
			Patient patient = data.get();
			if(newPatient.getAddress()!= null) {
				patient.setAddress(newPatient.getAddress());
			}
			if(newPatient.getEmail()!= null && !newPatient.getEmail().equals("") ) {
				patient.setEmail(newPatient.getEmail());
			}
			if(newPatient.getFirstName()!= null && !newPatient.getFirstName().equals("") ) {
				patient.setFirstName(newPatient.getFirstName());
			}
			if(newPatient.getLastName()!= null && !newPatient.getLastName().equals("") ) {
				patient.setLastName(newPatient.getLastName());
			}
			if(newPatient.getPassword()!= null && !newPatient.getPassword().equals("") ) {
				patient.setPassword(newPatient.getPassword());
			}
			
			if(newPatient.getPhone()!= null && !newPatient.getPhone().equals("") ) {
				patient.setPhone(newPatient.getPhone());
			}
			
			if(newPatient.getDoctors()!= null ) {
				patient.setDoctors(newPatient.getDoctors());
			}
			patientRepository.save(patient);
			return patient;
		}
		return null;
	}
	

}
