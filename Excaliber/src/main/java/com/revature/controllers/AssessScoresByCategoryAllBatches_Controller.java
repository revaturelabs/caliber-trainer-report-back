package com.revature.controllers;

import com.revature.services.AssessScoresByCategoryAllBatches_Service;
import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(path = "/assessscoresbycatergoryallbatches")
public class AssessScoresByCategoryAllBatches_Controller {
    private final AssessScoresByCategoryAllBatches_Service catAll;
    public Logger log = Logger.getLogger(TechnicalStatusByWeek_Controller.class);

    @Autowired
    public AssessScoresByCategoryAllBatches_Controller(AssessScoresByCategoryAllBatches_Service a) {
        catAll = a;
    }

    /**
     * TODO
     *
     * @param category
     * @return
     */
    @GetMapping(path = "/{category}")
    public ResponseEntity<AssessScoresByCategoryAllBatches> getScoresByCategoryAllBatches(@PathVariable("category") String category) {
        log.trace("Getting table data for AssessScoresByCategoryAllBatches/" + category);
        AssessScoresByCategoryAllBatches batches = new AssessScoresByCategoryAllBatches();
        batches = catAll.getAssessScoresByCategoryAllBatches(category);
        return ResponseEntity.ok(batches);
    }
}
