package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.data.AssessmentDAO;
import com.revature.data.BatchDAO;
import com.revature.data.CategoryDAO;
import com.revature.data.TrainerDAO;
import com.revature.data.WeekDAO;

@Service
public class StoreRetrieveService {
	private AssessmentDAO aDao;
	private BatchDAO bDao;
	private CategoryDAO cDao;
	private TrainerDAO tDao;
	private WeekDAO wDao;
	
	@Autowired
	public StoreRetrieveService(AssessmentDAO a, BatchDAO b, CategoryDAO c, TrainerDAO t, WeekDAO w) {
		aDao=a;
		bDao=b;
		cDao=c;
		tDao=t;
		wDao=w;
				
	}
	
	//Store methods
	public Integer addCategory(Category c) {
		return cDao.save(c).getId();
	}
	
	public Integer addAssessment (Assessment a) {
		return aDao.save(a).getAssessmentId();
	}
	public Integer addWeek (Week w) {
		return wDao.save(w).getWeekId();
	}
	
	public Integer addBatch (Batch b) {
		return bDao.save(b).getExBatchId();
	}
	
	public Integer addTrainer (Trainer t) {
		return tDao.save(t).getTrainerId();
	}
	
	//Retrieve method
	public Trainer getTrainerById(Integer id) {
		return tDao.findById(id).get();
	}
}
