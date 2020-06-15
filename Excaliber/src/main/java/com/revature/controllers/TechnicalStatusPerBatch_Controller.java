package com.revature.controllers;



import com.revature.services.TechnicalStatusPerBatch_Service;
import com.revature.tables.TechnicalStatusPerBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/TechnicalStatusPerBatch")
public class TechnicalStatusPerBatch_Controller {

    private final TechnicalStatusPerBatch_Service tServ;

    @Autowired
    public TechnicalStatusPerBatch_Controller(TechnicalStatusPerBatch_Service t) {

        this.tServ = t;
    }

    @GetMapping
    public ResponseEntity<TechnicalStatusPerBatch> getTechnicalStatusPerBatch() {
        return ResponseEntity.ok(this.tServ.returnTable(1));
    }

}
