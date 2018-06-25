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
import webdev.TrialConnect.models.Address;
import webdev.TrialConnect.repositories.AddressRepository;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class AddressService {
	@Autowired
	AddressRepository addressRepository;
	
	
	@PostMapping("/api/address")
	public Address createAddress(@RequestBody Address address) {
		return addressRepository.save(address);
	}
	
	@GetMapping("/api/addresses")
	public List<Address> findAllAddresses(){
		return (List<Address>) addressRepository.findAll();
	}
	
	@GetMapping("/api/address/{id}")
	public Address findAddressById(@PathVariable("id") int aid) {
		Optional<Address> data = addressRepository.findById(aid);
		if(data.isPresent()) {
			return data.get();
		}
		return null;	
	}
	
	@DeleteMapping("/api/address/{id}")
	public void deleteAddress(@PathVariable("id") int aid)
	{
		addressRepository.deleteById(aid);
	}
	
	@PutMapping("/api/address/{id}")
	public Address updateAddress(@PathVariable("id") int aid, @RequestBody Address newAddress) {
		Optional<Address> data = addressRepository.findById(aid);
		if(data.isPresent()) {
			Address address = data.get();
			if(newAddress.getStreet() != null && !newAddress.getStreet().equals("") ) {
			address.setStreet(newAddress.getStreet());
			}
			if(newAddress.getApartment() != null && !newAddress.getApartment().equals("") ) {
				address.setApartment(newAddress.getApartment());
				}
			if(newAddress.getCity() != null && !newAddress.getCity().equals("") ) {
				address.setCity(newAddress.getCity());
				}
			if(newAddress.getCountry() != null && !newAddress.getCountry().equals("") ) {
				address.setCountry(newAddress.getCountry());
				}
			if(newAddress.getState() != null && !newAddress.getState().equals("") ) {
				address.setState(newAddress.getState());
				}
			if(newAddress.getPatient() != null ) {
				address.setPatient(newAddress.getPatient());
				}
			if(newAddress.getDoctor() != null ) {
				address.setDoctor(newAddress.getDoctor());
				}
			
			return newAddress;
		}
		return null;
	}
	
	
	

}
