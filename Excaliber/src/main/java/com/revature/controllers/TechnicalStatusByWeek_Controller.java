package com.revature.controllers;

import com.revature.services.TechnicalStatusByWeek_Service;
import com.revature.tables.TechnicalStatusByWeek;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Technical status by week controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(path = "/TechnicalStatusByWeek")

public class TechnicalStatusByWeek_Controller {
    private final TechnicalStatusByWeek_Service serv;
    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(TechnicalStatusByWeek_Controller.class);

    /**
     * Instantiates a new Technical status by week controller.
     *
     * @param s the s
     */
    @Autowired
    public TechnicalStatusByWeek_Controller(TechnicalStatusByWeek_Service s) {
        serv = s;
    }

    /**
     * Handles Get request to /TechnicalStatusByWeek/{batch id}
     * and returns List<TechnicalStatusByWeek> in response body
     *
     * @return table data
     */
    @GetMapping
    public ResponseEntity<List<TechnicalStatusByWeek>> getTableData() {
        log.info("TechnicalStatusByWeek_Controller: "
                + "Getting table data for TechnicalStatusByWeek/");
        List<TechnicalStatusByWeek> tableObjects = serv.getTableData();
        return ResponseEntity.ok(tableObjects);
    }

}
