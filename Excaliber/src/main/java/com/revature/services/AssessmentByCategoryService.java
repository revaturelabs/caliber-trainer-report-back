package com.revature.services;

import com.revature.beans.*;
import com.revature.tables.AssessmentByCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assessment by category service.
 */
@Service
public class AssessmentByCategoryService {
	private final StoreRetrieveService SRSserv;

	/**
	 * Instantiates a new Assessment by category service.
	 *
	 * @param s the s
	 */
	@Autowired
	public AssessmentByCategoryService(StoreRetrieveService s) {
		SRSserv = s;
	}

	/**
	 * Gets abc table.
	 *
	 * @param id the id
	 * @return the abc table
	 */
	public AssessmentByCategory getABCTable(int id) {
		Trainer t = SRSserv.getTrainerById(id);
		AssessmentByCategory table = new AssessmentByCategory();

		List<Category> categories = SRSserv.getAllCategories();
		ArrayList<ArrayList<Float>> assessScores = new ArrayList<ArrayList<Float>>();
		ArrayList<ArrayList<Float>> rawScores = new ArrayList<ArrayList<Float>>();
		ArrayList<Float[]> averageForCat = new ArrayList<Float[]>();
		ArrayList<ArrayList<String>> typeForScore = new ArrayList<ArrayList<String>>();
		//Get rawScores and AssessmentScores for each category
		for (Category cat : categories) {
			ArrayList<Float> singleCatAScores = new ArrayList<Float>();
			ArrayList<Float> singleCatRawScores = new ArrayList<Float>();
			ArrayList<String> singleCatTypeForScore = new ArrayList<String>();
			for (Batch b : t.getBatches()) {
				for (Week w : b.getWeeks()) {
					for (Assessment a : w.getAssessments()) {
						if (a.getSkillCategory().getId()==cat.getId()) {
							Float assessScore=a.getAverage();
							Float rawScore=Float.valueOf(a.getScoreWeight());
							String type=a.getType();
							assessScore=(assessScore/100)*rawScore; //Convert AssessScore into suitable form
							singleCatAScores.add(assessScore);
							singleCatRawScores.add(rawScore);
							singleCatTypeForScore.add(type);
						}

					}
				}
			}
			assessScores.add(singleCatAScores); //Add scores for single category to list
			rawScores.add(singleCatRawScores);
			typeForScore.add(singleCatTypeForScore);
		}
		//Find average overall score for each category
		for (int i=0; i<assessScores.size(); i++) {
			float numeratorExam=0;
			float denominatorExam=0;
			float numeratorVerbal=0;
			float denominatorVerbal=0;
			float numeratorPresentation=0;
			float denominatorPresentation=0;
			float numeratorProject=0;
			float denominatorProject=0;
			float numeratorOther=0;
			float denominatorOther=0;

			for (int j=0; j<assessScores.get(i).size(); j++) {
				String type=typeForScore.get(i).get(j);
				if (type.contains("Exam")) {
					numeratorExam+=assessScores.get(i).get(j);
					denominatorExam+=rawScores.get(i).get(j);
				}else if (type.contains("Verbal")) {
					numeratorVerbal+=assessScores.get(i).get(j);
					denominatorVerbal+=rawScores.get(i).get(j);
				}else if (type.contains("Presentation")) {
					numeratorPresentation+=assessScores.get(i).get(j);
					denominatorPresentation+=rawScores.get(i).get(j);
				}else if (type.contains("Project")) {
					numeratorProject+=assessScores.get(i).get(j);
					denominatorProject+=rawScores.get(i).get(j);
				}else {
					numeratorOther+=assessScores.get(i).get(j);
					denominatorOther+=rawScores.get(i).get(j);
				}

			}
			float averageExam=0;
			float averageVerbal=0;
			float averagePresentation=0;
			float averageProject=0;
			float averageOther=0;
			if (denominatorExam!=0) {
				averageExam=(numeratorExam/denominatorExam)*100;
			}
			if (denominatorVerbal!=0) {
				averageVerbal=(numeratorVerbal/denominatorVerbal)*100;
			}
			if (denominatorPresentation!=0) {
				averagePresentation=(numeratorPresentation/denominatorPresentation)*100;
			}
			if (denominatorProject!=0) {
				averageProject=(numeratorProject/denominatorProject)*100;
			}
			if (denominatorOther!=0) {
				averageOther=(numeratorOther/denominatorOther)*100;
			}
			Float[] average= {averageExam, averageVerbal, averagePresentation, averageProject, averageOther};
			averageForCat.add(average);
		}


		table.setCategories(categories);

		table.setAverage(averageForCat);
		return table;
	}
}
