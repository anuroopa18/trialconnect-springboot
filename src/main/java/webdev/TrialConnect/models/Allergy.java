package webdev.TrialConnect.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Allergy {
	public enum AllergyType{
		food,medicine,other
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String cause;
    private String description;
    private String treatment;
    @ManyToOne
	@JsonIgnore
	private MedicalRecord medicalRecord;
	
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public AllergyType getAllergyType() {
		return allergyType;
	}
	public void setAllergyType(AllergyType allergyType) {
		this.allergyType = allergyType;
	}
	@Enumerated(EnumType.STRING)
	private AllergyType allergyType;

}
