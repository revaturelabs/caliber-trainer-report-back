package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.BatchTechnicalStatusBySkillCategoryDAO;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;

@Service
public class BatchTechnicalStatusBySkillCategoryService {
	BatchTechnicalStatusBySkillCategoryDAO dao;
	
	@Autowired
	public BatchTechnicalStatusBySkillCategoryService(BatchTechnicalStatusBySkillCategoryDAO v) {
		dao = v;
	}
	
	public List<BatchTechnicalStatusBySkillCategory> getTableData(){
		return dao.getTableData();
	}
}
