package com.revature.services;

import com.revature.Excaliber;
import com.revature.beans.*;
import com.revature.data.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Store retrieve service test.
 */
@SpringBootTest(classes= Excaliber.class)
class TrainerServiceTest {
	  /**
     * Sets up.
     */

    @Autowired
    private TrainerService trainerService;

    @MockBean
    private AssessmentDAO assessmentDAO;
    @MockBean
    private BatchDAO batchDAO;
    @MockBean
    private CategoryDAO categoryDAO;
    @MockBean
    private TrainerDAO trainerDAO;
    @MockBean
    private WeekDAO weekDAO;

    /**
     * Add category.
     */

    @Test
    void addCategoryThatDoesNotExist() {
        Category c = new Category();
        c.setId(1);
        c.setName("test");

        when(categoryDAO.save(c)).thenReturn(c);

        Integer retVal = trainerService.addCategory(c);
        assertEquals(1, retVal.intValue());
        verify(categoryDAO, times(1)).save(c);
    }

    @Test
    void addCategoryThatDoesExist() {
        Category c = new Category();
        c.setId(1);
        c.setName("test");

        when(categoryDAO.findCategoryByName(c.getName())).thenReturn(c);

        Integer retVal = trainerService.addCategory(c);
        assertEquals(1, retVal.intValue());
        verify(categoryDAO, times(1)).findCategoryByName(c.getName());
    }

   



    /**
     * Add entire trainer.
     */


    @Test
    void addEntireTrainer() {
        Trainer trainer= new Trainer();
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

        when(categoryDAO.findCategoryByName(cat2.getName())).thenReturn(cat2);
        when(assessmentDAO.save(assess)).thenReturn(assess);
        when(weekDAO.save(week)).thenReturn(week);
        when(batchDAO.save(batch)).thenReturn(batch);
        when(trainerDAO.save(trainer)).thenReturn(trainer);

        Trainer retVal = trainerService.addEntireTrainer(trainer);
        assertEquals(trainer,retVal);
    }

    /**
     * Gets Batches by Trainer.
     */

 

    /**
     * Gets trainer by id.
     */
    @Test
    void getTrainerByIdNotNull() {
        Trainer t = new Trainer();
        when(trainerDAO.findById(1)).thenReturn(java.util.Optional.of(t));

        Trainer retVal = trainerService.getTrainerById(1);
        assertEquals(t, retVal);
        verify(trainerDAO, times(1)).findById(1);

    }

    @Test
    void getTrainerByIdNull() {
        Trainer trainer = null;
        when(trainerDAO.findById(1)).thenReturn(Optional.ofNullable(trainer));

        Trainer retVal = trainerService.getTrainerById(1);
        assertEquals(null, retVal);
        verify(trainerDAO, times(1)).findById(1);
    }

    @Test
    void getTrainers(){
        List<Trainer> t = new ArrayList<>();
        when(trainerDAO.findAll()).thenReturn(t);

        List<Trainer> retVal = trainerService.getTrainers();
        assertEquals(t, retVal);
        verify(trainerDAO, times(1)).findAll();
    }

}
