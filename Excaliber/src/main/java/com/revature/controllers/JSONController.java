package com.revature.controllers;

import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import com.revature.utils.ParseJSON;
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
     * Add trainer boolean.
     *
     * @param payload JSON body to be stored in db
     * @return boolean boolean
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> add(@RequestBody String payload) {
        //set the JSON to be parsed
        setJson(payload);
        Trainer trainer = null;
        try {
            trainer = new ParseJSON(payload).getTrainerUsingJackson();
            //if trainer created
            SRSserv.addEntireTrainer(trainer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("NOT VALID JSON");
        }
        return ResponseEntity.ok().build();

    }



}
