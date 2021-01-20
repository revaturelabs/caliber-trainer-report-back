package com.revature.services;

import com.revature.Excaliber;
import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.controllers.JSONController;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.TechnicalStatusByWeek;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.controllers.JSONController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.function.EntityResponse;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ContextConfiguration(classes = Excaliber.class)
@RunWith(MockitoJUnitRunner.class)
class StatusByWeekServiceTest {
	@InjectMocks
	public StatusByWeekService tsbwServ; // class being tested 
	
	@Mock
	static TrainerService sRSserv;
	
	static Trainer trainer;
	
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
		week.setTechnicalStatus("null");
		weeks.add(week);
		batch.setWeeks(weeks);
		List<Batch> batches= new ArrayList<>();
		batches.add(batch);
		trainer.setBatches(batches);
	}

	@Test
	void getTechnicalStatusByWeekSreviceTest() throws Exception {

		
		when(sRSserv.getTrainerById(1)).thenReturn(trainer);
		MockitoAnnotations.initMocks(this);
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
