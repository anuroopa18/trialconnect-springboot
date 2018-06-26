package webdev.TrialConnect.models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String gender;
	private String problems;
	private String medicine;
	private String results;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date visits;
	

	@ManyToOne
	@JsonIgnore
	private Patient patient;
	
	 @OneToMany(mappedBy="medicalRecord")
	 private List<Vitals> vitals;
	 
	 @OneToMany(mappedBy="medicalRecord")
	 private List<Doctor> doctor;
	 
	 public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	@OneToMany(mappedBy="medicalRecord")
	 private List<Allergy> allergy;
	 
	 @OneToMany(mappedBy="medicalRecord")
	 private List<Vaccine> vaccine;
	 
	 
	public List<Allergy> getAllergy() {
		return allergy;
	}
	public void setAllergy(List<Allergy> allergy) {
		this.allergy = allergy;
	}
	public List<Vaccine> getVaccine() {
		return vaccine;
	}
	public void setVaccine(List<Vaccine> vaccine) {
		this.vaccine = vaccine;
	}
	public List<Vitals> getVitals() {
		return vitals;
	}
	public void setVitals(List<Vitals> vitals) {
		this.vitals = vitals;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProblems() {
		return problems;
	}
	public void setProblems(String problems) {
		this.problems = problems;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public Date getVisits() {
		return visits;
	}
	public void setVisits(Date visits) {
		this.visits = visits;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	
	

}
