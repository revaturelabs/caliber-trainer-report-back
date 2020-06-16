package com.revature.tables;

import java.util.ArrayList;

/* Batch Technical Status Bean
	
	***Bean to generate graph for Technical Status per batch according to skillCategory***
	*
	*User Story: 
		• To generate graphical representation of QC Technical Status
			per batch according to skillCategory.
			
	*Objective: 
		•Generate the metrics that allows to see how well a trainer is 
			performing per batch according to skillCategory.
			
	*Data-Points:
		•Batch ID from Batch
		•Batch Name from Batch
		•Technical Status from Batch's QC notes.
		•SkillCategory from Batch's Assessment.
*/

public class BatchTechnicalStatusBySkillCategory {
	
	private ArrayList<String> batchId;			// ID number of a batch
	private ArrayList<String> batchName;			// Name of a batch
	private ArrayList<int[]> technicalStatus;		// GOOD, BAD, etc for batch
	private ArrayList<String> skillCategory;		// skillCategory from Assessment eg: Java, SQL etc.
	private ArrayList<String> tSName;
	public ArrayList<String> gettSName() {
		return tSName;
	}

	public void settSName(ArrayList<String> tSName) {
		this.tSName = tSName;
	}

	//Constructor
	public BatchTechnicalStatusBySkillCategory() {
			batchId = new ArrayList<>();
			batchName = new ArrayList<>();
			technicalStatus = new ArrayList<>();
			skillCategory= new ArrayList<>();
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((skillCategory == null) ? 0 : skillCategory.hashCode());
		result = prime * result + ((tSName == null) ? 0 : tSName.hashCode());
		result = prime * result + ((technicalStatus == null) ? 0 : technicalStatus.hashCode());
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
		BatchTechnicalStatusBySkillCategory other = (BatchTechnicalStatusBySkillCategory) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (skillCategory == null) {
			if (other.skillCategory != null)
				return false;
		} else if (!skillCategory.equals(other.skillCategory))
			return false;
		if (tSName == null) {
			if (other.tSName != null)
				return false;
		} else if (!tSName.equals(other.tSName))
			return false;
		if (technicalStatus == null) {
			if (other.technicalStatus != null)
				return false;
		} else if (!technicalStatus.equals(other.technicalStatus))
			return false;
		return true;
	}

	public ArrayList<String> getBatchId() {
		return batchId;
	}

	public void setBatchId(ArrayList<String> batchId) {
		this.batchId = batchId;
	}

	public ArrayList<String> getBatchName() {
		return batchName;
	}

	public void setBatchName(ArrayList<String> batchName) {
		this.batchName = batchName;
	}

	public ArrayList<int[]> getTechnicalStatus() {
		return technicalStatus;
	}

	public void setTechnicalStatus(ArrayList<int[]> technicalStatus) {
		this.technicalStatus = technicalStatus;
	}

	public ArrayList<String> getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(ArrayList<String> skillCategory) {
		this.skillCategory = skillCategory;
	}

	@Override
	public String toString() {
		return "BatchTechnicalStatusBySkillCategory [batchId=" + batchId + ", batchName=" + batchName
				+ ", technicalStatus=" + technicalStatus + ", skillCategory=" + skillCategory + ", tSName=" + tSName
				+ "]";
	}
	
}
