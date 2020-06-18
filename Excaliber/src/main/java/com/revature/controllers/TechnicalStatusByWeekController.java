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
public class TechnicalStatusByWeekController {
    private final TechnicalStatusByWeek_Service serv;
    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(TechnicalStatusByWeekController.class);

    /**
     * Instantiates a new Technical status by week controller.
     *
     * @param t the t
     */
    @Autowired
    public TechnicalStatusByWeekController(TechnicalStatusByWeek_Service t) {
        serv = t;
    }

    /**
     * Handles Get request to /TechnicalStatusByWeek/{batch id}
     * and returns List<TechnicalStatusByWeek> in response body
     *
     * @return table data
     */
    @GetMapping
    public ResponseEntity<List<TechnicalStatusByWeek>> getTechnicalStatusByWeek() {
        log.info("TechnicalStatusByWeek_Controller: Getting TechnicalStatusByWeek");
        return ResponseEntity.ok(serv.getTechnicalStatusByWeek(1));
    }

}
