package com.revature.services;

import com.revature.beans.*;
import com.revature.data.*;
import org.apache.log4j.Logger;
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

    private final Logger log = Logger.getLogger(StoreRetrieveService.class);

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

//Store methods-basic
    public Integer addCategory(Category c) {
        Category category = cDao.findCategoryByName(c.getName()) ;
        if (category != null) {
            log.debug("Found" + c.getName() + category);
            return category.getId();
        }
        log.error("Did not Find" + c.getName());
        return cDao.save(c).getId();
    }
//Store method-entire trainer object
    public Trainer addEntireTrainer(Trainer t) {


        List<Batch> batches = new ArrayList<>();

        for (Batch batch : t.getBatches()) {
            List<Week> weeks = new ArrayList<>();

            for (Week week : batch.getWeeks()) {

                List<Assessment> assessments = new ArrayList<>();
                List<Category> categories = new ArrayList<>();
                for (Assessment a : week.getAssessments()) {

                    Category c = a.getSkillCategory();
                    c.setId(addCategory(c));
                    a.setSkillCategory(c);

                    assessments.add(aDao.save(a));
                }
                week.setAssessments(assessments);

                for (Category c : week.getCategories()) {
                    c.setId(addCategory(c));
                    categories.add(c);
                }
                week.setCategories(categories);
                weeks.add(wDao.save(week));

            }
            batch.setWeeks(weeks);
            batches.add(bDao.save(batch));
        }

        t.setBatches(batches);
        return tDao.save(t);
    }

    public Trainer getTrainerById(Integer id) {
        Optional<Trainer> trainer = tDao.findById(id);
        if (trainer.isPresent())
            return trainer.get();
        else
            return null;
    }

    public List<Trainer> getTrainers() {
        List<Trainer> trainers = tDao.findAll();
        return trainers;
    }
}
