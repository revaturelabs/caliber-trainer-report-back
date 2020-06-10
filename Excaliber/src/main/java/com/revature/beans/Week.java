package com.revature.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table
public class Week {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer weekId;
	@Column
	private String weekNumber; // what number week they are in; could be A or B for extended batches
	@Column
	private String batchId;
	@Column
	private String technicalStatus;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="",
			joinColumns=@JoinColumn(name=""),
			inverseJoinColumns=@JoinColumn(name=""))//need column names----------------------
	private Set<Category> categories;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="",
			joinColumns=@JoinColumn(name=""),
			inverseJoinColumns=@JoinColumn(name=""))//need column names----------------------
	private Set<Assessment> assessments; 

	public Week() {
		weekId = 0;
		weekNumber = "";
		//batchId = 0;
		technicalStatus = "";
		categories = null;
		assessments = null;
	}

	public Week(String weekNumber, String technicalStatus) {
		//this.weekId = weekId;
		this.weekNumber = weekNumber;
		//this.batchId = batchId;
		this.technicalStatus = technicalStatus;
		// TODO categories;
		// TODO assessments
		// TODO batchId
	}

	public Integer getWeekId() {
		return weekId;
	}

	public void setWeekId(Integer weekId) {
		this.weekId = weekId;
	}

	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getTechnicalStatus() {
		return technicalStatus;
	}
	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

	@Override
	public String toString() {
		return "Week{" +
				"weekId=" + weekId +
				", weekNumber='" + weekNumber + '\'' +
				", batchId=" + batchId +
				", technicalStatus='" + technicalStatus + '\'' +
				", categories=" + categories +
				", assessments=" + assessments +
				'}';
	}
}
