package com.revature.services;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.BatchTechnicalStatusBySkillCategory;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.controllers.JSONController;
import com.revature.data.CategoryDAO;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
@Transactional
		// to manage the session
class BatchTechnicalStatusByCategoryServiceTest {

	@InjectMocks
	private BatchStatBySkillCategoryService btsbscServ; // class being tested 

	@Mock
	TrainerService sRserv;
	@Mock
	CategoryDAO cDao;
	
	Trainer trainer;
	@BeforeEach
    void setUp() {
		trainer= new Trainer();
        trainer.setEmail("Email");
        trainer.setEmployeeId("1");
        trainer.setFirstName("Me");
        trainer.setId(1);
        trainer.setLastName("Me 2");
        List<Batch> batches = new ArrayList<>();
        Batch batch= new Batch();
        batch.setId(1);
        batch.setBatchName("Batch name");
        batch.setEndDate("Today");
        batch.setStartDate("Yestrday");
        batch.setLocation("NewYork");
        batch.setSkill("Automated");
        batch.setTrainerId(1);
        batches.add(batch);
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
        trainer.setBatches(batches);
    }
	/*
	 *  
	 */
	@Test
	void getTableData() {
		List<Category> cat = new ArrayList<Category>();
		Category java = new Category();
		java.setId(1);
		java.setName("Java");
		cat.add(java);
		Mockito.when(sRserv.getTrainerById(1)).thenReturn(trainer);
		Mockito.when(cDao.findAll()).thenReturn(cat);
		// call getTableData() and get returned object
		BatchTechnicalStatusBySkillCategory result = btsbscServ.getTableData(1);

		// check if returned object is a BatchTechnicalStatusBySkillCategory object
		assertTrue(result instanceof BatchTechnicalStatusBySkillCategory);
	}
}
