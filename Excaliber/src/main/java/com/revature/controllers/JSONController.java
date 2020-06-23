package com.revature.controllers;

import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.revature.utils.ParseJSON.*;

/**
 * The type Json controller.
 */
@RestController
@RequestMapping(path = "/JSONController")
public class JSONController {

    private final StoreRetrieveService SRSserv;
    private final Logger log = Logger.getLogger(JSONController.class);
    /**
     * Instantiates a new Json controller.
     *
     * @param s the s
     */
    @Autowired
    public JSONController(StoreRetrieveService s) {
        SRSserv = s;
    }

    /**
     * TODO
     *
     * @return string response entity
     */
    @GetMapping
    public ResponseEntity<String> getTrainer2() {


        Trainer trainer = getTrainer();
        List<Batch> batches = getBatch();
        trainer.setBatches(batches);
        SRSserv.addEntireTrainer(trainer);
        return ResponseEntity.ok().build();

    }

    /**
     * Add trainer boolean.
     *
     * @param payload JSON body to be stored in db
     * @return boolean boolean
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity add(@RequestBody String payload) {
        log.trace("Adding JSON to DB using POST");
        log.debug("payload = " + payload);
        //set the JSON to be parsed
        setJson(payload);
        Trainer trainer = null;
        try {
            //create a trainer from the JSON payload
            trainer = getTrainer();
            //get the batch data
            List<Batch> batches = getBatch();
            //give trainer the batches
            trainer.setBatches(batches);
            //if trainer created
            SRSserv.addEntireTrainer(trainer);
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body("NOT VALID JSON");
        }
        return ResponseEntity.ok().build();

    }



}
