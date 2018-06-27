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
import webdev.TrialConnect.models.Admin;
import webdev.TrialConnect.repositories.AdminRepository;


@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@PostMapping("/api/admin")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
	
	@GetMapping("/api/admins")
	public List<Admin> findAllAdmins(){
		return (List<Admin>) adminRepository.findAll();
	}
	
	@GetMapping("/api/admin/{id}")
	public Admin findAdminById(@PathVariable("id") int aid) {
		Optional<Admin> data = adminRepository.findById(aid);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@PostMapping("/api/findAdminByCredentials/admin")
	public Admin findDoctorByCredentials(@RequestBody Admin admin) {
		Admin ad = new Admin();
		Optional<Admin> data = adminRepository.findUserByCredentials(admin.getUsername(),admin.getPassword());
		if(data.isPresent()) {
			return data.get();
		}
		return ad;	
	}
	
	@DeleteMapping("/api/admin/{id}")
	public void deleteAdmin(@PathVariable("id") int aid)
	{
		adminRepository.deleteById(aid);
	}
	
	@PutMapping("/api/admin/{id}")
	public Admin updateAdmin(@PathVariable("id") int aid, @RequestBody Admin newAdmin) {
		Optional<Admin> data = adminRepository.findById(aid);
		if(data.isPresent()) {
			Admin admin = data.get();
			if(newAdmin.getEmail() != null && !newAdmin.getEmail().equals("") ) {
				admin.setEmail(newAdmin.getEmail());
			}
			if(newAdmin.getFirstName() != null && !newAdmin.getFirstName().equals("") ) {
				admin.setFirstName(newAdmin.getFirstName());
			}
			if(newAdmin.getLastName() != null && !newAdmin.getLastName().equals("") ) {
				admin.setLastName(newAdmin.getLastName());
			}
			if(newAdmin.getPassword() != null && !newAdmin.getPassword().equals("") ) {
				admin.setPassword(newAdmin.getPassword());
			}
			if(newAdmin.getPhone() != null && !newAdmin.getPhone().equals("") ) {
				admin.setPhone(newAdmin.getPhone());
			}
			if(newAdmin.getUsername() != null && !newAdmin.getUsername().equals("") ) {
				admin.setUsername(newAdmin.getUsername());
			}
			
			return newAdmin;
		}
		return null;
	}
	
	

}
