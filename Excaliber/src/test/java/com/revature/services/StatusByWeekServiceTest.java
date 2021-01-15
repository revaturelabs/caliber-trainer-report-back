package com.revature.services;

import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.TechnicalStatusByWeek;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.controllers.JSONController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
class StatusByWeekServiceTest {

	private final StatusByWeekService tsbwServ; // class being tested 
	private final JSONController jCtrl; // for access to getTrainer2() method used for initializing data

	@Mock
    TrainerService mockServ;
	
	
	
	@Autowired
	public StatusByWeekServiceTest(StatusByWeekService t, JSONController c) {
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

		//jCtrl.getTrainer2(); // initialize data

		// call getTechnicalStatusByWeek() and get returned list
		List<TechnicalStatusByWeek> result = tsbwServ.getTechnicalStatusByWeek(1);

		// check if returned list contains TechnicalStatusByWeek objects
		assertTrue(result.get(0) instanceof TechnicalStatusByWeek);
	}
	@Test
	void IncrementStatusTest() throws Exception {
		int id = 1;
		Trainer trainer = Mockito.mock(Trainer.class);
		List<TechnicalStatusByWeek> dataTransferObject = new ArrayList<>();
		
		for (Batch b: trainer.getBatches()) {
			for (Week w : b.getWeeks()) {
				for(Category category : w.getCategories()) {
					boolean match = false;
					for (TechnicalStatusByWeek categoryRow : dataTransferObject) {
					StatusByWeekService.IncrementStatus(w, categoryRow);
					break;
					}
				}
			}
			
		}
	}


}
