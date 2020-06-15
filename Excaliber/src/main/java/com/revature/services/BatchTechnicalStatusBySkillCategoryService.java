package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Trainer;
import com.revature.data.BatchTechnicalStatusBySkillCategoryDAO;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;

@Service
public class BatchTechnicalStatusBySkillCategoryService {
	private final StoreRetrieveService sRserv;
	
	@Autowired
	public BatchTechnicalStatusBySkillCategoryService(StoreRetrieveService v) {
		this.sRserv = v;
	}
	
	public List<BatchTechnicalStatusBySkillCategory> getTableData(int id){
			Trainer trainer = sRserv.getTrainerById(id);
		
		return null;
	}
}
