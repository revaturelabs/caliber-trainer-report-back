package com.revature.controllers;



import com.revature.services.TechnicalStatusPerBatchService;
import com.revature.tables.TechnicalStatusPerBatch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Technical status per batch controller.
 */
@RestController
@RequestMapping(path = "/TechnicalStatusPerBatch")
public class TechnicalStatusPerBatchController {

    private final TechnicalStatusPerBatchService tServ;

    /**
     * Instantiates a new Technical status per batch controller.
     *
     * @param t the t
     */
    @Autowired
    public TechnicalStatusPerBatchController(TechnicalStatusPerBatchService t) {

        this.tServ = t;
    }

    /**
     * ToDO
     *
     * @return technical status per batch
     */
    @GetMapping
    public ResponseEntity<List<TechnicalStatusPerBatch>> getTechnicalStatusPerBatch() {
        return ResponseEntity.ok(this.tServ.technicalStatusPerBatchTable(1));
    }

}
