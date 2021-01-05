package com.revature.beans;

import java.util.HashSet;
import java.util.Set;


public class CompleteBatch {

	/*
	 id : number;
    batchId : string;
    name : string;
    startDate : string;
    endDate : string;
    skill : string;
    location : string;
    type : string;
    qcNotes : QCNote[];
    assessments : Assessment[];
    currentWeek : number;
	 */
	
	private Integer id;
	private String batchId;
	private String startDate;
	private String endDate;
	private String skill;
	private String location;
	private String type;
	private Integer currentWeek;
	
	//stored in JSON form
	private Set<String> QCNotes;
	private Set<String> assessments;
	
	
	public CompleteBatch()
	{
		id = -1;
		batchId = "";
		startDate = "";
		skill = "";
		location = "";
		type = "";
		currentWeek = -1;
		QCNotes = new HashSet<String>();
		assessments = new HashSet<String>();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBatchId() {
		return batchId;
	}


	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getCurrentWeek() {
		return currentWeek;
	}


	public void setCurrentWeek(Integer currentWeek) {
		this.currentWeek = currentWeek;
	}


	public Set<String> getQCNotes() {
		return QCNotes;
	}


	public void setQCNotes(Set<String> qCNotes) {
		QCNotes = qCNotes;
	}


	public Set<String> getAssessments() {
		return assessments;
	}


	public void setAssessments(Set<String> assessments) {
		this.assessments = assessments;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((QCNotes == null) ? 0 : QCNotes.hashCode());
		result = prime * result + ((assessments == null) ? 0 : assessments.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((currentWeek == null) ? 0 : currentWeek.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompleteBatch other = (CompleteBatch) obj;
		if (QCNotes == null) {
			if (other.QCNotes != null)
				return false;
		} else if (!QCNotes.equals(other.QCNotes))
			return false;
		if (assessments == null) {
			if (other.assessments != null)
				return false;
		} else if (!assessments.equals(other.assessments))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (currentWeek == null) {
			if (other.currentWeek != null)
				return false;
		} else if (!currentWeek.equals(other.currentWeek))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CompleteBatch [id=" + id + ", batchId=" + batchId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", skill=" + skill + ", location=" + location + ", type=" + type + ", currentWeek=" + currentWeek
				+ ", QCNotes=" + QCNotes + ", assessments=" + assessments + "]";
	}
	
	
	
}
