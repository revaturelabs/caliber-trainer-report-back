package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Batch;
import com.revature.beans.BatchTSCategory;
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
			
			ArrayList<BatchTSCategory> batchCategory = new ArrayList<BatchTSCategory>();
			
			
			
			List<Category> cat = sRserv.getAllCategories();
			
			for(Category ca: cat) {
				
				double good = 0;
				double poor = 0;
				double average = 0;
				double superstar = 0;
				for(Batch b: trainer.getBatches()) {
					BatchTSCategory batch = new BatchTSCategory();
					batch.setCategoryName(ca.getName());
					batch.setBatchId(b.getBatchId());
					
					int catGood = 0;
					int catPoor = 0;
					int catAverage = 0;
					int catSuperStar = 0;
					
					for(Week w: b.getWeeks()) {
						for(Category c: w.getCategories()) {
							if(c.getName().equalsIgnoreCase(ca.getName()) && w.getTechnicalStatus().equalsIgnoreCase("Good")) {
								catGood++;
							} else if(c.getName().equalsIgnoreCase(ca.getName()) && w.getTechnicalStatus().equalsIgnoreCase("Average")) {
								catAverage++;
							} else if(c.getName().equalsIgnoreCase(ca.getName()) && w.getTechnicalStatus().equalsIgnoreCase("Poor")) {
								catPoor++;
							} else if(c.getName().equalsIgnoreCase(ca.getName()) && w.getTechnicalStatus().equalsIgnoreCase("Superstar")) {
								catSuperStar++;
							}
						}
					}
					
					good = catGood;
					average =catAverage;
					poor = catPoor;
					superstar = catSuperStar;
					
					double[] finalVal = {};
					double goodAvg = 0;
					double aveAverage = 0;
					double poorAvg = 0;
					double superAvg = 0;
					double total = good+average+poor+superstar;
					
					if(total != 0) {
					
					goodAvg = (good/total)*100;
					aveAverage = (average/total)*100;
					poorAvg = (poor/total)*100;
					superAvg = (superstar/total)*100;
			
					}
					
					ArrayList<Double> finalCount = new ArrayList<Double>();
					finalCount.add(good);
					finalCount.add(average);
					finalCount.add(poor);
					finalCount.add(superstar);
					ArrayList<Double> finalAverageVal = new ArrayList<Double>();
					finalAverageVal.add(goodAvg);
					finalAverageVal.add(aveAverage);
					finalAverageVal.add(poorAvg);
					finalAverageVal.add(superAvg);
					
					
					batch.setTechScore(finalCount);
					batch.setAvgVal(finalAverageVal);
					batchCategory.add(batch);
				}
				
				tableObject.setBatchByCategory(batchCategory);
			}
				return tableObject;
	}
}
