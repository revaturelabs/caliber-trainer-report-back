package com.revature.services;

import com.revature.beans.*;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
 * Service for BatchTechnicalStatus by Category.
 */

@Service
public class BatchTechnicalStatusBySkillCategoryService implements BatchTechnicalStatusByCategoryService {
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
	 * @return Batch Techincal Status By Category
	 */
	@Override
	public BatchTechnicalStatusBySkillCategory getTableData(int id){
		
			Trainer trainer = sRserv.getTrainerById(id);
			
			BatchTechnicalStatusBySkillCategory tableObject = new BatchTechnicalStatusBySkillCategory();
			
			ArrayList<QCTSCategory> catList = new ArrayList<>();
			
			List<Category> cat = sRserv.getAllCategories();
			//Category loop started
			for(Category ca: cat) {
				QCTSCategory catego = new QCTSCategory();
				catego.setCategoryName(ca.getName());
				
				ArrayList<BatchTSCategory> batchCategory = new ArrayList<>();

				double good = 0;
				double poor = 0;
				double average = 0;
				double superstar = 0;
				//Batch Loop started
				for(Batch b: trainer.getBatches()) {
					BatchTSCategory batch = new BatchTSCategory();
					QCTSScore scores = new QCTSScore();
					batch.setBatchName(b.getBatchName());
					
					int catGood = 0;
					int catPoor = 0;
					int catAverage = 0;
					int catSuperStar = 0;
					//Week Loop started
					for(Week w: b.getWeeks()) {
						//category within week loop started
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
						} //Category with in week for loop ends here
					} // Week for loop ends here 
					good = catGood;
					average =catAverage;
					poor = catPoor;
					superstar = catSuperStar;
					
					double goodAvg = 0;
					double aveAverage = 0;
					double poorAvg = 0;
					double superAvg = 0;
					double total = good+average+poor+superstar;
					
					//Calculating average for TechnicalStatus counts
					if(total != 0) {

						goodAvg = (good / total) * 100;
						aveAverage = (average / total) * 100;
						poorAvg = (poor / total) * 100;
						superAvg = (superstar / total) * 100;

					}
					//Adding TechnicalStatus counts in a Score object

					scores.setGood(good);
					scores.setAverage(average);
					scores.setPoor(poor);
					scores.setSuperstar(superstar);
					scores.setAvgGood(goodAvg);
					scores.setAvgAverage(aveAverage);
					scores.setAvgPoor(poorAvg);
					scores.setAvgSuperstar(superAvg);

					batch.setScore(scores);

					batchCategory.add(batch);
					
				} //Batch for loop ends here
				
				catego.setBatches(batchCategory);
				catList.add(catego);
				tableObject.setBatchByCategory(catList);
			} //Category for loop ends here 
				return tableObject;
	}
}
