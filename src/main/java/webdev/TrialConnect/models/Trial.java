package webdev.TrialConnect.models;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String briefDescription ;
	private String detailedDescription;
	private Boolean recruitmentStatus;
	private Date firstPosted;
	private Date lastUpdatePosted;
	private String conditionOrDisease;
	private String treatmentDrug;
	private int phase=0;
	private String outcomes;
	private String inclusionCriteria;
	private String exclusionCriteria;
	private int contactInfo;
	
	@ManyToOne
	@JsonIgnore
	private Patient patient;
	

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBriefDescription() {
		return briefDescription;
	}
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public Boolean getRecruitmentStatus() {
		return recruitmentStatus;
	}
	public void setRecruitmentStatus(Boolean recruitmentStatus) {
		this.recruitmentStatus = recruitmentStatus;
	}
	public Date getFirstPosted() {
		return firstPosted;
	}
	public void setFirstPosted(Date firstPosted) {
		this.firstPosted = firstPosted;
	}
	public Date getLastUpdatePosted() {
		return lastUpdatePosted;
	}
	public void setLastUpdatePosted(Date lastUpdatePosted) {
		this.lastUpdatePosted = lastUpdatePosted;
	}
	public String getConditionOrDisease() {
		return conditionOrDisease;
	}
	public void setConditionOrDisease(String conditionOrDisease) {
		this.conditionOrDisease = conditionOrDisease;
	}
	public String getTreatmentDrug() {
		return treatmentDrug;
	}
	public void setTreatmentDrug(String treatmentDrug) {
		this.treatmentDrug = treatmentDrug;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}
	public String getOutcomes() {
		return outcomes;
	}
	public void setOutcomes(String outcomes) {
		this.outcomes = outcomes;
	}
	public String getInclusionCriteria() {
		return inclusionCriteria;
	}
	public void setInclusionCriteria(String inclusionCriteria) {
		this.inclusionCriteria = inclusionCriteria;
	}
	public String getExclusionCriteria() {
		return exclusionCriteria;
	}
	public void setExclusionCriteria(String exclusionCriteria) {
		this.exclusionCriteria = exclusionCriteria;
	}
	public int getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(int contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	
	
}