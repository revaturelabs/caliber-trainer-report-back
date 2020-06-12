package com.revature.controllers;

import com.revature.services.TechnicalStatusByWeek_Service;
import com.revature.tables.TechnicalStatusByWeek;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(path = "/TechnicalStatusByWeek")

public class TechnicalStatusByWeek_Controller {
    private final TechnicalStatusByWeek_Service serv;
    public Logger log = Logger.getLogger(TechnicalStatusByWeek_Controller.class);

    @Autowired
    public TechnicalStatusByWeek_Controller(TechnicalStatusByWeek_Service s) {
        serv = s;
    }

    // Handles Get request to /TechnicalStatusByWeek/{batch id}
    // and returns List<TechnicalStatusByWeek> in response body
    @GetMapping(path = "/{batchId}")
    public ResponseEntity<List<TechnicalStatusByWeek>> getTableData(@PathVariable("batchId") String batchId) {
        log.info("TechnicalStatusByWeek_Controller: "
                + "Getting table data for TechnicalStatusByWeek/" + batchId);
        List<TechnicalStatusByWeek> tableObjects = serv.getTableData(batchId);
        return ResponseEntity.ok(tableObjects);
    }

}
