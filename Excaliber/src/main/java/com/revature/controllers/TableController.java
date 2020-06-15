package com.revature.controllers;

import com.revature.services.TableService;
import com.revature.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Table controller.
 */
@RestController
@RequestMapping(path = "/{trainer_id}")
public class TableController {


    private final TableService tServ;

    /**
     * Instantiates a new Table controller.
     *
     * @param tServ the t serv
     */
    @Autowired
    public TableController(TableService tServ) {
        this.tServ = tServ;
    }

    /**
     * ToDO
     *
     * @param trainer_id the trainer id
     * @return technical status per batch
     */
    @RequestMapping(path = "/TechnicalStatusPerBatch")
    public ResponseEntity<TechnicalStatusPerBatch> getTechnicalStatusPerBatch(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.technicalStatusPerBatchTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @param trainer_id the trainer id
     * @return assessment by batch
     */
    @RequestMapping(path = "/AssessmentByBatch")
    public ResponseEntity<AssessmentByBatch> getAssessmentByBatch(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.assessmentByBatchTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @param trainer_id the trainer id
     * @return assessment by category
     */
    @RequestMapping(path = "/AssessmentByCategory")
    public ResponseEntity<AssessmentByCategory> getAssessmentByCategory(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.assessmentByCategoryTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @param trainer_id the trainer id
     * @return assess scores by category all batches
     */
    @RequestMapping(path = "/AssessScoresByCategoryAllBatches")
    public ResponseEntity<AssessScoresByCategoryAllBatches> getAssessScoresByCategoryAllBatches(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.assessScoresByCategoryAllBatchesTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @param trainer_id the trainer id
     * @return batch technical status
     */
    @RequestMapping(path = "/BatchTechnicalStatus")
    public ResponseEntity<BatchTechnicalStatus> getBatchTechnicalStatus(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.batchTechnicalStatusTable(trainer_id));
    }

    /**
     * ToDO
     *
     * @param trainer_id the trainer id
     * @return technical status by week
     */
    @RequestMapping(path = "/TechnicalStatusByWeek")
    public ResponseEntity<TechnicalStatusByWeek> getTechnicalStatusByWeek(@PathVariable int trainer_id) {
        return ResponseEntity.ok(this.tServ.technicalStatusByWeekTable(trainer_id));
    }


}
