package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.controllers.JSONController;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;

@SpringBootTest
@Transactional // to manage the session
class BatchTechnicalStatusByCategoryServiceTest {

	private final BatchTechnicalStatusBySkillCategoryService btsbscServ; // class being tested 
	private final JSONController jCtrl; // for access to getTrainer2() method used for initializing data
	
	@Autowired
	public BatchTechnicalStatusByCategoryServiceTest(
			BatchTechnicalStatusBySkillCategoryService t, JSONController c) {
		btsbscServ = t;
		jCtrl = c;
	}
	
	/*
	 *  Integration Test:
	 *    -Method being Tested: BatchTechnicalStatusBySkillCategoryService.getTableData()
	 *      -Should return a BatchTechnicalStatusBySkillCategory object
	 *    -Dependency: JSONController.getTrainer2()
	 *      -Initializes Trainer data to be processed by the method
	 */
    @Test
    void getTableData() {

    	jCtrl.getTrainer2(); // initialize data
		
		// call getTableData() and get returned object
    	BatchTechnicalStatusBySkillCategory result = btsbscServ.getTableData(1);
		
		// check if returned object is a BatchTechnicalStatusBySkillCategory object
		assertTrue(result instanceof BatchTechnicalStatusBySkillCategory);
    }
}
