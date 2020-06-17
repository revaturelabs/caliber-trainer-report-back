package com.revature.controllers;

import com.revature.services.AssessScoresByCategoryAllBatches_Service;
import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Assess scores by category all batches controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/assessscoresbycategoryallbatches")
public class AssessScoresByCategoryAllBatches_Controller {
    private final AssessScoresByCategoryAllBatches_Service catAll;
    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(TechnicalStatusByWeek_Controller.class);

    /**
     * Instantiates a new Assess scores by category all batches controller.
     *
     * @param a the a
     */
    @Autowired
    public AssessScoresByCategoryAllBatches_Controller(AssessScoresByCategoryAllBatches_Service a) {
        catAll = a;
    }

    /**
     * TODO
     *
     * @param category the category
     * @return scores by category all batches
     */
    @GetMapping(path = "/{category}")
    public ResponseEntity<AssessScoresByCategoryAllBatches> getScoresByCategoryAllBatches(@PathVariable("category") String category) {
        log.trace("Getting table data for AssessScoresByCategoryAllBatches/" + category);
        AssessScoresByCategoryAllBatches batches = new AssessScoresByCategoryAllBatches();
        batches = catAll.getAssessScoresByCategoryAllBatches(1, category);
        return ResponseEntity.ok(batches);
    }
}
