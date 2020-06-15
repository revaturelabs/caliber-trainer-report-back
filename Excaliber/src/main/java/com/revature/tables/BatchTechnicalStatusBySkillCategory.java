package com.revature.tables;

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
}
