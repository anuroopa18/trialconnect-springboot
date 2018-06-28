package webdev.TrialConnect.repositories;

import org.springframework.data.repository.CrudRepository;

import webdev.TrialConnect.models.Medication;

public interface MedicationRepository extends CrudRepository<Medication, Integer>{

}
