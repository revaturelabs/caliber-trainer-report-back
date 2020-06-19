package com.revature.services;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;

import com.revature.beans.Category;
import com.revature.data.AssessmentDAO;
import com.revature.data.BatchDAO;
import com.revature.data.CategoryDAO;
import com.revature.data.TrainerDAO;
import com.revature.data.WeekDAO;

/**
 * The type Store retrieve service test.
 */


@RunWith(SpringRunner.class)
class StoreRetrieveServiceTest {
	
//	 private final AssessmentDAO aDao;
//	    private final BatchDAO bDao;
//	    private final CategoryDAO cDao;
//	    private final TrainerDAO tDao;
//	    private final WeekDAO wDao;
	
	//StoreRetrieveService service = new StoreRetrieveService(AssessmentDAO a, BatchDAO b, CategoryDAO c, TrainerDAO t, WeekDAO w);
	 

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * Add category.
     */
    @Test
    void addCategory() {
    	
//    	Category category = new Category();
//    	
//    	category.setId(5);
//    	category.setName("Java");
//    	
//    	
//    	int expected = 5;
//    	int actual = service.addCategory(category);
    }

    /**
     * Add assessment.
     */
    @Test
    void addAssessment() {
    }

    /**
     * Add week.
     */
    @Test
    void addWeek() {
    }

    /**
     * Add batch.
     */
    @Test
    void addBatch() {
    }

    /**
     * Add trainer.
     */
    @Test
    void addTrainer() {
    }

    /**
     * Add entire trainer.
     */
    @Test
    void addEntireTrainer() {
    }

    /**
     * Gets trainer by id.
     */
    @Test
    void getTrainerById() {
    }
}
