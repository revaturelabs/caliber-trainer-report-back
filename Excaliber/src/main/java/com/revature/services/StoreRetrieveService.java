package com.revature.services;

import com.revature.beans.*;
import com.revature.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The type Store retrieve service.
 */


@Service
public class StoreRetrieveService {
    private final AssessmentDAO aDao;
    private final BatchDAO bDao;
    private final CategoryDAO cDao;
    private final TrainerDAO tDao;
    private final WeekDAO wDao;

    /**
     * Instantiates a new Store retrieve service.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param t the t
     * @param w the w
     */
    @Autowired
    public StoreRetrieveService(AssessmentDAO a, BatchDAO b, CategoryDAO c, TrainerDAO t, WeekDAO w) {
        aDao = a;
        bDao = b;
        cDao = c;
        tDao = t;
        wDao = w;

    }

    /**
     * Add category integer.
     *
     * @param c the c
     * @return the integer
     */
//Store methods-basic
    public Integer addCategory(Category c) {
        Category category = getCategoryByName(c.getName());
        if (category != null) {
            System.out.println("Found" + c.getName() + category);
            return category.getId();
        }
        System.out.println("Did not Find" + c.getName());
        return cDao.save(c).getId();
    }

    /**
     * Add assessment integer.
     *
     * @param a the a
     * @return the integer
     */
    public Integer addAssessment(Assessment a) {
        return aDao.save(a).getId();
    }

    /**
     * Add week integer.
     *
     * @param w the w
     * @return the integer
     */
    public Integer addWeek(Week w) {
        return wDao.save(w).getId();
    }

    /**
     * Add batch integer.
     *
     * @param b the b
     * @return the integer
     */
    public Integer addBatch(Batch b) {
        return bDao.save(b).getId();
    }

    /**
     * Add trainer integer.
     *
     * @param t the t
     * @return the integer
     */
    public Integer addTrainer(Trainer t) {
        return tDao.save(t).getTrainerId();
    }

    /**
     * Add entire trainer trainer.
     *
     * @param t the t
     * @return the trainer
     */
//Store method-entire trainer object
    public Trainer addEntireTrainer(Trainer t) {


        List<Batch> batches = new ArrayList<Batch>();

        for (Batch batch : t.getBatches()) {
            List<Week> weeks = new ArrayList<Week>();

            for (Week week : batch.getWeeks()) {

                List<Assessment> assessments = new ArrayList<Assessment>();
                List<Category> categories = new ArrayList<Category>();
                for (Assessment a : week.getAssessments()) {

                    Category c = a.getSkillCategory();
                    c.setId(addCategory(c));
                    a.setSkillCategory(c);
                    a.setId(addAssessment(a));
                    assessments.add(a);
                }
                week.setAssessments(assessments);

                for (Category c : week.getCategories()) {
                    c.setId(addCategory(c));
                    categories.add(c);
                }
                week.setCategories(categories);
                week.setId(addWeek(week));
                weeks.add(week);

            }
            batch.setWeeks(weeks);
            batch.setId(addBatch(batch));
            batches.add(batch);
        }

        t.setBatches(batches);
        t.setId(addTrainer(t));
        return t;
    }

    /**
     * Gets trainer by id.
     *
     * @param id the id
     * @return the trainer by id
     */

    public Trainer getTrainerById(Integer id) {
    	Optional<Trainer> trainer = tDao.findById(id);
        if (trainer.isPresent())
        	return trainer.get();
        else
        	return null;
    }

    /**
     * get Category By Name
     *
     * @param name
     * @return Category
     */
    private Category getCategoryByName(String name) {
        return cDao.findCategoryByName(name);
    }

    /**
     * Gets all category
     *
     * @return
     */
    public List<Category> getAllCategories() {
        return cDao.findAll();
    }

    class NotFoundException extends RuntimeException {

        NotFoundException(String data, String what) {
            super("Could not find " + what + data);
        }
    }
}
