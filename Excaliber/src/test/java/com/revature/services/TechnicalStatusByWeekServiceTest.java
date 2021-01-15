package com.revature.services;

import com.revature.controllers.JSONController;
import com.revature.tables.TechnicalStatusByWeek;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
//@Disabled
class TechnicalStatusByWeekServiceTest {

	private final TechnicalStatusByWeekService tsbwServ; // class being tested 
	private final JSONController jCtrl; // for access to getTrainer2() method used for initializing data

	@Autowired
	public TechnicalStatusByWeekServiceTest(TechnicalStatusByWeekService t, JSONController c) {
		tsbwServ = t;
		jCtrl = c;
	}

	/*
	 *  Integration Test:
	 *    -Method being Tested: TechnicalStatusByWeekService.getTechnicalStatusByWeek()
	 *      -Should return a List of TechnicalStatusByWeek objects
	 *    -Dependency: JSONController.getTrainer2()
	 *      -Initializes Trainer data to be processed by the method
	 */
	@Test
	void getTechnicalStatusByWeekSreviceTest() throws Exception {

		jCtrl.getTrainer2(); // initialize data

		// call getTechnicalStatusByWeek() and get returned list
		List<TechnicalStatusByWeek> result = tsbwServ.getTechnicalStatusByWeek(1);

		// check if returned list contains TechnicalStatusByWeek objects
		assertTrue(result.get(0) instanceof TechnicalStatusByWeek);
		}
	
}
