package webdev.TrialConnect.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date dateOfAdministration;
	private String brand;
	private int doses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfAdministration() {
		return dateOfAdministration;
	}
	public void setDateOfAdministration(Date dateOfAdministration) {
		this.dateOfAdministration = dateOfAdministration;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getDoses() {
		return doses;
	}
	public void setDoses(int doses) {
		this.doses = doses;
	}
	

}
