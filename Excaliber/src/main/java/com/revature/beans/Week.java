package com.revature.beans;

import javax.persistence.*;
import java.util.Set;

public class Week {
	private Integer weekId;
	private String weekNumber; // what number week they are in; could be A or B for extended batches
	private String batchId;
	private String technicalStatus;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "",
			joinColumns = @JoinColumn(name = ""),
			inverseJoinColumns = @JoinColumn(name = ""))//need column names----------------------
	private Set<Category> categories;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "",
			joinColumns = @JoinColumn(name = ""),
			inverseJoinColumns = @JoinColumn(name = ""))//need column names----------------------
	private Set<Assessment> assessments;

	public Week() {
		weekId = 0;
		weekNumber = "";
		batchId = "";
		technicalStatus = "";
		categories = null;
		assessments = null;
	}

	public Week(String weekNumber, String technicalStatus) {
		this.weekId = weekId;
		this.weekNumber = weekNumber;
		this.batchId = batchId;
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
