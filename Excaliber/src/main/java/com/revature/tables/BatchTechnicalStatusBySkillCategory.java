package com.revature.tables;

import java.util.ArrayList;
import com.revature.beans.QCTSCategory;

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
	
	private ArrayList<QCTSCategory> batchByCategory;
	
	
	//Constructor
	public BatchTechnicalStatusBySkillCategory() {
			batchByCategory = new ArrayList<>();
		}

	public ArrayList<QCTSCategory> getBatchByCategory() {
		return batchByCategory;
	}

	public void setBatchByCategory(ArrayList<QCTSCategory> batchByCategory) {
		this.batchByCategory = batchByCategory;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchByCategory == null) ? 0 : batchByCategory.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "BatchTechnicalStatusBySkillCategory [batchByCategory=" + batchByCategory + "]";
	}
	
	


	
}
