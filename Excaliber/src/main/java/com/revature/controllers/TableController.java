package com.revature.controllers;

import com.revature.services.*;
import com.revature.tables.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Table controller.
 */
@RestController
@RequestMapping(path = "/{trainerId}")
public class TableController {

    private final Logger log = Logger.getLogger(TableController.class);

    private final TechnicalStatusPerBatchService statusPerBatchService;
    private final TechnicalStatusByWeekService statusByWeekService;
    private final BatchTechnicalStatusBySkillCategoryService technicalStatusBySkillCategoryService;
    private final AssessScoresByCategoryAllBatchesService scoresByCategoryService;
    private final AssessmentByCategoryService assessmentByCategoryService;
    private final AssessmentByBatchService assessmentByBatchService;

    /**
     * @param statusPerBatchService                 the Service for statusPerBatch
     * @param statusByWeekService                   the Service for statusByWeek
     * @param technicalStatusBySkillCategoryService the Service for technicalStatusBySkillCategory
     * @param scoresByCategoryService               the Service for scoresByCategory
     * @param assessmentByCategoryService           the Service for assessmentByCategory
     * @param assessmentByBatchService              the Service for assessmentByBatch
     */
    @Autowired
    public TableController(TechnicalStatusPerBatchService statusPerBatchService,
                           TechnicalStatusByWeekService statusByWeekService,
                           BatchTechnicalStatusBySkillCategoryService technicalStatusBySkillCategoryService,
                           AssessScoresByCategoryAllBatchesService scoresByCategoryService,
                           AssessmentByCategoryService assessmentByCategoryService,
                           AssessmentByBatchService assessmentByBatchService) {

        this.statusPerBatchService = statusPerBatchService;
        this.statusByWeekService = statusByWeekService;
        this.technicalStatusBySkillCategoryService = technicalStatusBySkillCategoryService;
        this.scoresByCategoryService = scoresByCategoryService;
        this.assessmentByCategoryService = assessmentByCategoryService;
        this.assessmentByBatchService = assessmentByBatchService;
    }

    /**
     * sends TechnicalStatusPerBatch table data
     *
     * @param trainerId the trainer id
     * @return technical status per batch
     */
    @GetMapping(path = "/TechnicalStatusPerBatch")
    public ResponseEntity<TechnicalStatusPerBatch> getTechnicalStatusPerBatch(@PathVariable int trainerId) {
        log.trace("Getting table data for AssessmentByBatch");
        return ResponseEntity.ok(this.statusPerBatchService.technicalStatusPerBatchTable(trainerId));
    }

    /**
     * sends AssessmentByBatch table data
     *
     * @param trainerId the trainer id
     * @return assessment by batch
     */
    @GetMapping(path = "/AssessmentByBatch")
    public ResponseEntity<List<AssessmentByBatch>> getAssessmentByBatch(@PathVariable int trainerId) {
        log.trace("Getting table data for AssessmentByBatch");
        return ResponseEntity.ok(assessmentByBatchService.getABBTable(trainerId));
    }

    /**
     * sends AssessmentByCategory table data
     *
     * @param trainerId the trainer id
     * @return assessment by category
     */
    @GetMapping(path = "/AssessmentByCategory")
    public ResponseEntity<AssessmentByCategory> getAssessmentByCategory(@PathVariable int trainerId) {
        log.trace("Getting table data for AssessmentByCategory");
        return ResponseEntity.ok(assessmentByCategoryService.getABCTable(trainerId));
    }

    /**
     * Sends AssessScoresByCategoryAllBatches table data
     *
     * @param trainerId the trainer id
     * @return assess scores by category all batches
     */
    @GetMapping(path = "/AssessScoresByCategoryAllBatches")
    public ResponseEntity<AssessScoresByCategoryAllBatches> getAssessScoresByCategoryAllBatches(@PathVariable int trainerId) {
        log.trace("Getting table data for AssessScoresByCategoryAllBatches");
        AssessScoresByCategoryAllBatches batches =
                scoresByCategoryService.getAssessScoresByCategoryAllBatches(trainerId);
        return ResponseEntity.ok(batches);
    }

    /**
     * Sends  TechnicalStatusByWeek table data
     *
     * @param trainerId the trainer id
     * @return technical status by week table data
     */
    @GetMapping(path = "/TechnicalStatusByWeek")
    public ResponseEntity<List<TechnicalStatusByWeek>> getTechnicalStatusByWeek(@PathVariable int trainerId) {
        log.info("Getting TechnicalStatusByWeek");
        return ResponseEntity.ok(statusByWeekService.getTechnicalStatusByWeek(trainerId));
    }

    /**
     * Sends  BatchTechnicalStatusBySkillCategory table data
     *
     * @param trainerId the trainer id
     * @return BatchTechnicalStatusBySkillCategory table data
     */
    @GetMapping(path = "/BatchTechnicalStatusBySkillCategory")
    public ResponseEntity<BatchTechnicalStatusBySkillCategory> getTableDataObject(@PathVariable int trainerId) {
        log.trace("Getting table data for BatchTechnicalStatusBySkillCategory");
        return ResponseEntity.ok(this.technicalStatusBySkillCategoryService.getTableData(1));
    }

}
