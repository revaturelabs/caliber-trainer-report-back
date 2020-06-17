package com.revature.tables;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BatchTSCategory;
import com.revature.beans.Category;

/* Batch Technical Status Bean
	
	***Bean to generate graph for Technical Status per batch according to Category***
	*
	*User Story: 
		• To generate graphical representation of QC Technical Status
			per batch according to Category.
			
	*Objective: 
		•Generate the metrics that allows to see how well a trainer is 
			performing per batch according to Category.
			
	*Data-Points:
		•Batch ID from Batch
		•Batch Name from Batch
		•Technical Status from Batch's QC notes.
		•Category from Batch's QC notes.
*/

public class BatchTechnicalStatusBySkillCategory {
	
	private ArrayList<String> batchId;			// ID number of a batch
	private ArrayList<String> batchName;			// Name of a batch
	private ArrayList<int[]> technicalStatus;		// GOOD, BAD, etc for batch
	private List<Category> categories;		// Category eg: Java, SQL etc.
	private ArrayList<Float> tSName;
	private ArrayList<BatchTSCategory> batchByCategory;
	
	
	//Constructor
	public BatchTechnicalStatusBySkillCategory() {
			batchId = new ArrayList<>();
			batchName = new ArrayList<>();
			technicalStatus = new ArrayList<>();
			categories= new ArrayList<>();
			tSName = new ArrayList<>();
			batchByCategory = new ArrayList<BatchTSCategory>();
		}
	
	

	public ArrayList<BatchTSCategory> getBatchByCategory() {
		return batchByCategory;
	}



	public void setBatchByCategory(ArrayList<BatchTSCategory> batchByCategory) {
		this.batchByCategory = batchByCategory;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchByCategory == null) ? 0 : batchByCategory.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
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
		if (batchByCategory == null) {
			if (other.batchByCategory != null)
				return false;
		} else if (!batchByCategory.equals(other.batchByCategory))
			return false;
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
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
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
	
	public ArrayList<Float> gettSName() {
		return tSName;
	}

	public void settSName(ArrayList<Float> tSName) {
		this.tSName = tSName;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "BatchTechnicalStatusBySkillCategory [batchId=" + batchId + ", batchName=" + batchName
				+ ", technicalStatus=" + technicalStatus + ", categories=" + categories + ", tSName=" + tSName
				+ ", batchByCategory=" + batchByCategory + "]";
	}
	
}
