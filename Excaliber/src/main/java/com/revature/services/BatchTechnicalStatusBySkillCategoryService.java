<<<<<<< HEAD
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
=======
package com.revature.services;

import com.revature.data.BatchTechnicalStatusBySkillCategoryDAO;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchTechnicalStatusBySkillCategoryService {
	BatchTechnicalStatusBySkillCategoryDAO dao;

	@Autowired
	public BatchTechnicalStatusBySkillCategoryService(BatchTechnicalStatusBySkillCategoryDAO v) {
		dao = v;
	}

	public List<BatchTechnicalStatusBySkillCategory> getTableData() {
		return dao.getTableData();
	}
}
>>>>>>> f2505bd9e12f23e5fde710915be0324cac90906c
