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

import webdev.TrialConnect.models.Doctor;
import webdev.TrialConnect.repositories.DoctorRepository;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@PostMapping("/api/doctor")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@GetMapping("/api/doctors")
	public List<Doctor> findAllDoctors(){
		return (List<Doctor>) doctorRepository.findAll();
	}
	
	@PostMapping("/api/findDoctorByCredentials/doctor")
	public Doctor findDoctorByCredentials(@RequestBody Doctor doctor) {
		Optional<Doctor> data = doctorRepository.findUserByCredentials(doctor.getUsername(),doctor.getPassword());
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	
	@GetMapping("/api/doctor/{id}")
	public Doctor findDoctorById(@PathVariable("id") int did) {
		Optional<Doctor> data = doctorRepository.findById(did);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@DeleteMapping("/api/doctor/{id}")
	public void deleteDoctor(@PathVariable("id") int did)
	{
		doctorRepository.deleteById(did);
	}
	
	@PutMapping("/api/doctor/{id}")
	public Doctor updateDoctor(@PathVariable("id") int did, @RequestBody Doctor newDoctor) {
		Optional<Doctor> data = doctorRepository.findById(did);
		if(data.isPresent()) {
			Doctor doctor = data.get();
			if(newDoctor.getAddress()!= null) {
				doctor.setAddress(newDoctor.getAddress());
			}
			if(newDoctor.getEmail()!= null && !newDoctor.getEmail().equals("") ) {
				doctor.setEmail(newDoctor.getEmail());
			}
			if(newDoctor.getFirstName()!= null && !newDoctor.getFirstName().equals("") ) {
				doctor.setFirstName(newDoctor.getFirstName());
			}
			if(newDoctor.getLastName()!= null && !newDoctor.getLastName().equals("") ) {
				doctor.setLastName(newDoctor.getLastName());
			}
			if(newDoctor.getPassword()!= null && !newDoctor.getPassword().equals("") ) {
				doctor.setPassword(newDoctor.getPassword());
			}
			if(newDoctor.getPatients()!= null) {
				doctor.setPatients(newDoctor.getPatients());
			}
			if(newDoctor.getPhone()!= null && !newDoctor.getPhone().equals("") ) {
				doctor.setPhone(newDoctor.getPhone());
			}
			if(newDoctor.getSpecialization()!= null && !newDoctor.getSpecialization().equals("") ) {
				doctor.setSpecialization(newDoctor.getSpecialization());
			}
			 
			doctorRepository.save(doctor);
			return doctor;
		}
		return null;
	}
	
}
