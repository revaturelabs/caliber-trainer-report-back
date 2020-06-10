package com.revature.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Batch {
	private Integer exBatchId; // our primary key 
	private String batchId; // key from caliber
	private String batchName;
	private Date startDate;
	private Date endDate;
	private String skill;
	private String location;
	//private String type; // always Revature?
	private Trainer trainer;
	private Set<Week> weeks = new HashSet<Week>();

	public Batch() {
		exBatchId = 0;
		this.batchId = "";
		batchName = "";
		this.startDate = null;
		this.endDate = null;
		this.skill = "";
		this.location = "";
		trainer = null;
		weeks = null;
	}


	public Batch(String batchId, String batchName, String startDate, String endDate, String skill, String location) {
		this.batchId = batchId;
		this.batchName = batchName;
//		this.startDate = startDate;
//		this.endDate = endDate;
		this.skill = skill;
		this.location = location;
	}


	public Integer getExBatchId() {
		return exBatchId;
	}

	public void setExBatchId(Integer exBatchId) {
		this.exBatchId = exBatchId;
	}

	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Set<Week> getWeeks() {
		return weeks;
	}

	public void setWeeks(Set<Week> weeks) {
		this.weeks = weeks;
	}

	@Override
	public String toString() {
		return "Batch{" +
				"exBatchId=" + exBatchId +
				", batchId='" + batchId + '\'' +
				", batchName='" + batchName + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", skill='" + skill + '\'' +
				", location='" + location + '\'' +
				", trainer=" + trainer +
				", weeks=" + weeks +
				'}';
	}

}
