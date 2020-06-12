package com.revature.services;

import com.revature.beans.*;
import com.revature.data.*;

import java.util.HashSet;
import java.util.Set;

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
	
	//Store methods-basic
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
	
	//Store method-entire trainer object
	public Trainer addEntireTrainer (Trainer t) {
		Set<Assessment> assessments=new HashSet<Assessment>();
		Set<Category> categories=new HashSet<Category>();
		Set<Week> weeks=new HashSet<Week>();
		Set<Batch> batches=new HashSet<Batch>();
		
		for (Batch batch:t.getBatches()) {
			for (Week week:batch.getWeeks()) {
				for (Assessment a:week.getAssessments()) {
					Category c=a.getSkillCategory();
					c.setId(addCategory(c));
					a.setSkillCategory(c);
					a.setId(addAssessment(a));
					assessments.add(a);
				}
				week.setAssessments(assessments);
				
				for (Category c:week.getCategories()) {
					c.setId(addCategory(c));
					categories.add(c);
				}
				week.setCategories(categories);
				
				week.setId(addWeek(week));
				weeks.add(week);
			}
			batch.setWeeks(weeks);
			batch.setId(addBatch(batch));
			batches.add(batch);
		}
		
		t.setBatches(batches);
		t.setId(addTrainer(t));
		return t;
	}
	
	//Retrieve method
	public Trainer getTrainerById(Integer id) {
		return tDao.findById(id).get();
	}
}
