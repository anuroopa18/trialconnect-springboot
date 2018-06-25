package webdev.TrialConnect.repositories;

import org.springframework.data.repository.CrudRepository;

import webdev.TrialConnect.models.Vaccine;

public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {

}
