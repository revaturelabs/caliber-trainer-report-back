package com.revature.services;

import com.revature.Excaliber;
import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.controllers.JSONController;
import com.revature.tables.TechnicalStatusByWeek;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional

@SpringBootTest(classes=Excaliber.class)

class TechnicalStatusByWeekServiceTest {

	private final TechnicalStatusByWeekService tsbwServ; // class being tested 
	@MockBean
	JSONController jCtrl; // for access to getTrainer2() method used for initializing data
	
	
	static Trainer trainer;

	static MockMvc mockMvc;
	@MockBean
	StoreRetrieveService srs;

	@Autowired
	public TechnicalStatusByWeekServiceTest(TechnicalStatusByWeekService t) {
		tsbwServ = t;
	

		//mockMvc = MockMvcBuilders.standaloneSetup(TechnicalStatusBy.class).build();
		
		
		
	}
	@BeforeAll
	public static void setUp() {
		trainer= new Trainer();
		trainer.setEmail("Email");
		trainer.setEmployeeId("1");
		trainer.setFirstName("Me");
		trainer.setId(1);
		trainer.setLastName("Me 2");
		Batch batch= new Batch();
		batch.setId(1);
		batch.setBatchName("Batch name");
		batch.setEndDate("Today");
		batch.setStartDate("Yestrday");
		batch.setLocation("NewYork");
		batch.setSkill("Automated");
		batch.setTrainerId(1);
		List<Week> weeks= new ArrayList<>();
		Week week = new Week();
		week.setId(1);
		week.setBatchId("1");
		Category cat2 = new Category();
		cat2.setId(1);
		cat2.setName("Java");
		List<Category> cat = new ArrayList<>();
		cat.add(cat2);
		week.setCategories(cat);
		Assessment assess= new Assessment();
		assess.setAverage((float) 1);
		assess.setId(1);
		assess.setScoreWeight(2);
		assess.setSkillCategory(cat2);
		assess.setType("Java");
		List<Assessment> asse= new ArrayList<>();
		asse.add(assess);
		week.setAssessments(asse);
		week.setTechnicalStatus("IN progress");
		weeks.add(week);
		batch.setWeeks(weeks);
		List<Batch> batches= new ArrayList<>();
		batches.add(batch);
		trainer.setBatches(batches);
	}

	@Test
	void getTechnicalStatusByWeekSreviceTest() throws Exception {
	
		ResponseEntity<String> mockResponse = new ResponseEntity<>(trainer.toString(),HttpStatus.OK);
		Trainer mockresp=trainer;
		Mockito.when(srs.getTrainerById(296)).thenReturn(trainer);
	
	//	jCtrl.getTrainer2(); // initialize data
		// call getTechnicalStatusByWeek() and get returned list
		List<TechnicalStatusByWeek> result = tsbwServ.getTechnicalStatusByWeek(296);

		// check if returned list contains TechnicalStatusByWeek objects
		assertTrue(result.get(0) instanceof TechnicalStatusByWeek);
		}
	
}
