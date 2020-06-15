package com.revature.tables;

<<<<<<< HEAD
=======
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

>>>>>>> eeb442111e08a1cee75e01eb27b9e635892f8555
public class BatchTechnicalStatusBySkillCategory {
	private String batchId;			// ID number of a batch
	private String batchName;			// Name of a batch
	private String technicalStatus;		// GOOD, BAD, etc for batch
	private String skillCategory;		// skillCategory from Assessment eg: Java, SQL etc.
	
	//Constructor
	public BatchTechnicalStatusBySkillCategory() {
			batchId = "";
			batchName = "";
			technicalStatus = "";
			skillCategory= "";
		}
	//Constructor with parameters
	public BatchTechnicalStatusBySkillCategory(String batchId, String batchName, String technicalStatus, String skillCategory) {
			this.batchId = batchId;
			this.batchName = batchName;
			this.technicalStatus = technicalStatus;
			this.skillCategory = skillCategory;
	}
<<<<<<< HEAD
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
	public String getTechnicalStatus() {
		return technicalStatus;
	}
	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}
	public String getSkillCategory() {
		return skillCategory;
	}
	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}
=======
	
	//Getters and setters
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

	public String getTechnicalStatus() {
		return technicalStatus;
	}

	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}
	
	//HashCode and equals()
>>>>>>> eeb442111e08a1cee75e01eb27b9e635892f8555
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((skillCategory == null) ? 0 : skillCategory.hashCode());
		result = prime * result + ((technicalStatus == null) ? 0 : technicalStatus.hashCode());
		return result;
	}
<<<<<<< HEAD
=======

>>>>>>> eeb442111e08a1cee75e01eb27b9e635892f8555
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
		if (technicalStatus == null) {
			if (other.technicalStatus != null)
				return false;
		} else if (!technicalStatus.equals(other.technicalStatus))
			return false;
		return true;
	}
<<<<<<< HEAD
=======
	
	//toString()
>>>>>>> eeb442111e08a1cee75e01eb27b9e635892f8555
	@Override
	public String toString() {
		return "BatchTechnicalStatusBySkillCategory [batchId=" + batchId + ", batchName=" + batchName
				+ ", technicalStatus=" + technicalStatus + ", skillCategory=" + skillCategory + "]";
	}
	
<<<<<<< HEAD
=======
	

	
	
	 
	
	

>>>>>>> eeb442111e08a1cee75e01eb27b9e635892f8555
}
