package webdev.TrialConnect.repositories;

import org.springframework.data.repository.CrudRepository;

import webdev.TrialConnect.models.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	

}
