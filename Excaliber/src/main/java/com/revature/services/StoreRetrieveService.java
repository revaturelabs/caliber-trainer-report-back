package com.revature.services;

import com.revature.beans.*;
import com.revature.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreRetrieveService {
	private final AssessmentDAO aDao;
	private final BatchDAO bDao;
	private final CategoryDAO cDao;
	private final TrainerDAO tDao;
	private final WeekDAO wDao;

	@Autowired
	public StoreRetrieveService(AssessmentDAO a, BatchDAO b, CategoryDAO c, TrainerDAO t, WeekDAO w) {
		aDao = a;
		bDao = b;
		cDao = c;
		tDao = t;
		wDao = w;

	}
	
	//Store methods
	public Integer addCategory(Category c) {
		return cDao.save(c).getId();
	}
	
	public Integer addAssessment (Assessment a) {
		return aDao.save(a).getId();
	}
	public Integer addWeek (Week w) {
		return wDao.save(w).getId();
	}
	
	public Integer addBatch (Batch b) {
		return bDao.save(b).getId();
	}
	
	public Integer addTrainer (Trainer t) {
		return tDao.save(t).getTrainerId();
	}
	
	//Retrieve method
	public Trainer getTrainerById(Integer id) {
		return tDao.findById(id).get();
	}
}
