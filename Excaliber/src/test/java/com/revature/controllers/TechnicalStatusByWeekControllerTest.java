package com.revature.controllers;

import com.revature.tables.TechnicalStatusByWeek;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;;

@SpringBootTest
@Transactional // to manage the session
class TechnicalStatusByWeekControllerTest {
	
	private final TechnicalStatusByWeekController tsbwCtrl; // class being tested 
	private final JSONController jCtrl; // for access to getTrainer2() method used for initializing data
	
	@Autowired
	public TechnicalStatusByWeekControllerTest(TechnicalStatusByWeekController t, JSONController c) {
		tsbwCtrl = t;
		jCtrl = c;
	}
	
	/*
	 *  Integration Test:
	 *    -Method being Tested: TechnicalStatusByWeekController.getTechnicalStatusByWeek()
	 *      -Should return ResponseEntity<List<TechnicalStatusByWeek>>
	 *    -Dependency: JSONController.getTrainer2()
	 *      -Initializes Trainer data to be processed by the method
	 */
	@Test
    public void getTechnicalStatusByWeekControllerTest() throws Exception {
		
		jCtrl.getTrainer2(); // initialize data
		
		// call getTechnicalStatusByWeek() and get returned list
		ResponseEntity<List<TechnicalStatusByWeek>> result = tsbwCtrl.getTechnicalStatusByWeek();
		
		// check if result returned a ResponseEntity
		assertTrue(result instanceof ResponseEntity);
    }
	

}
