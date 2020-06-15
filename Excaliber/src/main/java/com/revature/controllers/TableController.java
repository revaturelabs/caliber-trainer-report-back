package com.revature.controllers;

import com.revature.services.TableService;
import com.revature.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/{trainer_id}")
public class TableController {


    private final TableService tServ;

    @Autowired
    public TableController(TableService tServ) {
        this.tServ = tServ;
    }

    /**
     * ToDO
     *
     * @return
     */
    @RequestMapping(path = "/TechnicalStatusPerBatch")
    public ResponseEntity<TechnicalStatusPerBatch> getTechnicalStatusPerBatch(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.technicalStatusPerBatchTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @return
     */
    @RequestMapping(path = "/AssessmentByBatch")
    public ResponseEntity<AssessmentByBatch> getAssessmentByBatch(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.assessmentByBatchTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @return
     */
    @RequestMapping(path = "/AssessmentByCategory")
    public ResponseEntity<AssessmentByCategory> getAssessmentByCategory(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.assessmentByCategoryTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @return
     */
    @RequestMapping(path = "/AssessScoresByCategoryAllBatches")
    public ResponseEntity<AssessScoresByCategoryAllBatches> getAssessScoresByCategoryAllBatches(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.assessScoresByCategoryAllBatchesTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @return
     */
    @RequestMapping(path = "/BatchTechnicalStatus")
    public ResponseEntity<BatchTechnicalStatus> getBatchTechnicalStatus(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.batchTechnicalStatusTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @return
     */
    @RequestMapping(path = "/TechnicalStatusByWeek")
    public ResponseEntity<TechnicalStatusByWeek> getTechnicalStatusByWeek(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.technicalStatusByWeekTable(trainer_id));
    }


}
