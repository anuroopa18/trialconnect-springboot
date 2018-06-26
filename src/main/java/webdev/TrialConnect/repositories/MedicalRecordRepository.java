package webdev.TrialConnect.repositories;


import org.springframework.data.repository.CrudRepository;


import webdev.TrialConnect.models.MedicalRecord;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Integer> {
	


}
