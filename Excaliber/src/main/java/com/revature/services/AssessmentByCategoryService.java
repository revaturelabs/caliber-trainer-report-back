package com.revature.services;

import com.revature.beans.*;

import com.revature.data.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentByCategoryService {
	private final StoreRetrieveService SRSserv;
	private final CategoryDAO cDao;
	@Autowired
	public AssessmentByCategoryService(StoreRetrieveService s, CategoryDAO c) {
		SRSserv=s;
		cDao = c;
	}

	public List<AssessmentByCategory> getABCTable(int id) {

		Trainer t = SRSserv.getTrainerById(id);

		List<Category> categories = cDao.findAll();
		List<Assessment> assessments = getTrainerAssessments(t);

		ArrayList<ArrayList<Float>> assessScores = new ArrayList<ArrayList<Float>>();
		ArrayList<ArrayList<Float>> rawScores = new ArrayList<ArrayList<Float>>();
		ArrayList<Float[]> averageForCat = new ArrayList<Float[]>();
		ArrayList<ArrayList<String>> typeForScore = new ArrayList<ArrayList<String>>();
		//Get rawScores and AssessmentScores for each category
		for (Category cat : categories) {
			ArrayList<Float> singleCatAScores = new ArrayList<Float>();
			ArrayList<Float> singleCatRawScores = new ArrayList<Float>();
			ArrayList<String> singleCatTypeForScore = new ArrayList<String>();

			for (Assessment a : assessments) {
				if (a.getSkillCategory().getId() == cat.getId()) {
					Float assessScore = a.getAverage();
					Float rawScore = Float.valueOf(a.getScoreWeight());
					String type = a.getType();

					singleCatAScores.add(assessScore);
					singleCatRawScores.add(rawScore);
					singleCatTypeForScore.add(type);
				}


			}
			assessScores.add(singleCatAScores); //Add scores for single category to list
			rawScores.add(singleCatRawScores);
			typeForScore.add(singleCatTypeForScore);
		}
		//Find average overall score for each category
		for (int i = 0; i < assessScores.size(); i++) {

			averageForCat.add(calculateAverage(i, assessScores, rawScores, typeForScore));
		}


		return createABCList(categories, averageForCat);
	}



	public Float[] calculateAverage(int i,ArrayList<ArrayList<Float>> assessScores,ArrayList<ArrayList<Float>> rawScores,ArrayList<ArrayList<String>> typeForScore) {
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
    	
    	for (int j=0;j<assessScores.get(i).size();j++) {
    		String type=typeForScore.get(i).get(j);
    		if (type.contains("Exam")) {
				numeratorExam += (assessScores.get(i).get(j) / 100) * rawScores.get(i).get(j);
				denominatorExam += rawScores.get(i).get(j);
			}else if (type.contains("Verbal")) {
				numeratorVerbal += (assessScores.get(i).get(j) / 100) * rawScores.get(i).get(j);
				denominatorVerbal += rawScores.get(i).get(j);
			}else if (type.contains("Presentation")) {
				numeratorPresentation += (assessScores.get(i).get(j) / 100) * rawScores.get(i).get(j);
				denominatorPresentation += rawScores.get(i).get(j);
			}else if (type.contains("Project")) {
				numeratorProject += (assessScores.get(i).get(j) / 100) * rawScores.get(i).get(j);
				denominatorProject += rawScores.get(i).get(j);
			}else {
				numeratorOther += (assessScores.get(i).get(j) / 100) * rawScores.get(i).get(j);
				denominatorOther += rawScores.get(i).get(j);
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
		if (denominatorOther != 0) {
			averageOther = (numeratorOther / denominatorOther) * 100;
		}
		Float[] average = {averageExam, averageVerbal, averagePresentation, averageProject, averageOther};

		return average;


	}

	public List<AssessmentByCategory> createABCList(List<Category> categories, List<Float[]> averageForCat) {
		ArrayList<AssessmentByCategory> ABCList = new ArrayList<AssessmentByCategory>();
		for (int i = 0; i < categories.size(); i++) {
			AssessmentByCategory aBC = new AssessmentByCategory();
			aBC.setCategory(categories.get(i).getName());
			aBC.setAverage(averageForCat.get(i));
			ABCList.add(aBC);
		}
		return ABCList;
	}

	public List<Assessment> getTrainerAssessments(Trainer t) {
		List<Assessment> aList = new ArrayList<Assessment>();
		for (Batch b : t.getBatches()) {
			for (Week w : b.getWeeks()) {
				for (Assessment a : w.getAssessments()) {
					aList.add(a);
				}
			}
		}
		return aList;
	}
}

