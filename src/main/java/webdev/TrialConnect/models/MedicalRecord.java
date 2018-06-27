package webdev.TrialConnect.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "medicalRecord")
	private List<MedicalConditions> medicalConditions;

	@OneToMany(mappedBy = "medicalRecord")
	private List<Allergy> allergies;

	@OneToMany(mappedBy = "medicalRecord")
	private List<Medication> medicine;

	@OneToOne(mappedBy = "medicalRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Patient patient;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Vitals vitals;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Allergy> getAllergy() {
		return allergies;
	}

	public void setAllergy(List<Allergy> allergy) {
		this.allergies = allergy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Medication> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medication> medicine) {
		this.medicine = medicine;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Vitals getVitals() {
		return vitals;
	}

	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public List<MedicalConditions> getMedicalConditions() {
		return medicalConditions;
	}

	public void setMedicalConditions(List<MedicalConditions> medicalConditions) {
		this.medicalConditions = medicalConditions;
	}

}
