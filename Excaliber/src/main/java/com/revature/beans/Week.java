package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

public class Week {
	private Integer weekId;
	private String weekNumber; // what number week they are in; could be A or B for extended batches
	private Integer batchId;
	private String technicalStatus;
	private Set<String> categories = new HashSet<String>();
	private Set<Assessment> assessments = new HashSet<Assessment>();

	public Week() {
		weekId = 0;
		weekNumber = "";
		batchId = 0;
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
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public String getTechnicalStatus() {
		return technicalStatus;
	}
	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}
	public Set<String> getCategories() {
		return categories;
	}
	public void setCategories(Set<String> categories) {
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
