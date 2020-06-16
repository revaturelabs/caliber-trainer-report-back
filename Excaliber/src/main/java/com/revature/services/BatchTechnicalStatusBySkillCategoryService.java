package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;
/*
 * Service for BatchTechnicalStatus by Category.
 */

@Service
public class BatchTechnicalStatusBySkillCategoryService {
	private final StoreRetrieveService sRserv;
	/*
	 * New Instance of BatchTechnicalStatusBySkillCategory.
	 * @param v 
	 * 
	 */
	@Autowired
	public BatchTechnicalStatusBySkillCategoryService(StoreRetrieveService v) {
		this.sRserv = v;
	}
	
	/*
	 * @param id
	 * @return Batch Techincal Status By Skill Category
	 */
	
	public BatchTechnicalStatusBySkillCategory getTableData(int id){
			Trainer trainer = sRserv.getTrainerById(id);
			BatchTechnicalStatusBySkillCategory tableObject = new BatchTechnicalStatusBySkillCategory();
			
			ArrayList<String> categoryName = new ArrayList<String>();
			
			ArrayList<String> batchIds = new ArrayList<String>();
			
			ArrayList<String> techStatus = new ArrayList<String>();
			
			ArrayList<String> batchName = new ArrayList<String>();
			
			ArrayList<int[]> techStatusScore = new ArrayList<int[]>();
					
			for(Batch b: trainer.getBatches()) {
				batchIds.add(b.getBatchId());
				batchName.add(b.getBatchName());
				for(Week w : b.getWeeks()) {
					int Java = 0;
					for(Category c : w.getCategories()) {
						if(categoryName.contains("Java")) {
							Java++;
						} else {
							categoryName.add(c.getName());
						}
						
						techStatus.add(w.getTechnicalStatus());
					}
					
					int[] scores = {Java};
					techStatusScore.add(scores);
				}
				categoryName.add(" ");
				
				techStatus.add(" ");
				
				
				
			}
			 
			tableObject.setSkillCategory(categoryName);
			tableObject.setBatchId(batchIds);
			tableObject.settSName(techStatus);
			tableObject.setBatchName(batchName);
			tableObject.setTechnicalStatus(techStatusScore);
			
			
		return tableObject;
	}
}
