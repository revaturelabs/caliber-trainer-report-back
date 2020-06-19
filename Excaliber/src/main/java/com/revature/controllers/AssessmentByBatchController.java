package com.revature.controllers;

import com.revature.services.AssessmentByBatchService;
import com.revature.tables.AssessmentByBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * The type Assessment by batch controller.
 */
@RestController
@RequestMapping(path = "/AssessmentByBatch")
public class AssessmentByBatchController {
    private final AssessmentByBatchService aBBserv;

    /**
     * Instantiates a new Assessment by batch controller.
     *
     * @param a the a
     */
    @Autowired
    public AssessmentByBatchController(AssessmentByBatchService a) {
        aBBserv = a;
    }

    /**
     * Get abb table response entity.
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<List<AssessmentByBatch>> getABBTable() {
        return ResponseEntity.ok(aBBserv.getABBTable(1));
    }

}
