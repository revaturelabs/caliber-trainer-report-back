package com.revature.services;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.AssessmentByBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assessment by batch service.
 */
@Service
public class AssessmentByBatchService {
	private final StoreRetrieveService SRSserv;

	/**
	 * Instantiates a new Assessment by batch service.
	 *
	 * @param s the s
	 */
	@Autowired
	public AssessmentByBatchService(StoreRetrieveService s) {
		SRSserv=s;
	}

	/**
	 * Get abb table list.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<AssessmentByBatch> getABBTable (int id){
		Trainer t=SRSserv.getTrainerById(id);
			
		return loopBatches(t.getBatches());
	}

	/**
	 * Loop batches list.
	 *
	 * @param batches the batches
	 * @return the list
	 */
	public List<AssessmentByBatch> loopBatches(List<Batch> batches){
		ArrayList<AssessmentByBatch> aBBList=new ArrayList<AssessmentByBatch>();
		for (Batch b:batches) {
			AssessmentByBatch aBB=new AssessmentByBatch();
			aBB.setBatchId(b.getBatchId());
			aBB.setBatchName(b.getBatchName());
			ArrayList<Float> aScores=new ArrayList<Float>();
	    	ArrayList<Float> rawScores=new ArrayList<Float>();
	    	ArrayList<String> typeForScore=new ArrayList<String>();
	    	
	     	for (Week w:b.getWeeks()) {
	    		for (Assessment a:w.getAssessments()) {
	    			Float assessScore=a.getAverage();
    				Float rawScore=Float.valueOf(a.getScoreWeight());
    				String type=a.getType();

					aScores.add(assessScore);
    				rawScores.add(rawScore);
    				typeForScore.add(type);
	    		}
	    	}
	     	
	     	float[] average=calculateAverages(aScores, rawScores, typeForScore );
	    	aBB.setAssessmentScores(average);
	    	aBBList.add(aBB);
		
		}
		return aBBList;
		
	}

	/**
	 * Calculate averages float [ ].
	 *
	 * @param aScores      the a scores
	 * @param rawScores    the raw scores
	 * @param typeForScore the type for score
	 * @return the float [ ]
	 */
	public float[] calculateAverages(ArrayList<Float> aScores, ArrayList<Float> rawScores, ArrayList<String> typeForScore ) {
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
    	
    	for (int i=0;i<aScores.size();i++) {
    		
	  		String type=typeForScore.get(i);
    		if (type.contains("Exam")) {
				numeratorExam += (aScores.get(i) / 100) * rawScores.get(i);
				denominatorExam += rawScores.get(i);
			}else if (type.contains("Verbal")) {
				numeratorVerbal += (aScores.get(i) / 100) * rawScores.get(i);
				denominatorVerbal += rawScores.get(i);
			}else if (type.contains("Presentation")) {
				numeratorPresentation += (aScores.get(i) / 100) * rawScores.get(i);
				denominatorPresentation += rawScores.get(i);
			}else if (type.contains("Project")) {
				numeratorProject += (aScores.get(i) / 100) * rawScores.get(i);
				denominatorProject += rawScores.get(i);
			}else {
				numeratorOther += (aScores.get(i) / 100) * rawScores.get(i);
				denominatorOther += rawScores.get(i);
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
    	float[] average= {averageExam, averageVerbal, averagePresentation, averageProject, averageOther};
		
    	return average;
	}
	

}
