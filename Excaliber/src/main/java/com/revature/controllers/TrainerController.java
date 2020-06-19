package com.revature.controllers;


import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Json controller.
 */
@RestController
@RequestMapping(path = "/Trainer")
public class TrainerController {

    private final StoreRetrieveService SRSserv;

    @Autowired
    public TrainerController(StoreRetrieveService srSserv) {
        SRSserv = srSserv;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getTrainers() {
        return ResponseEntity.ok(SRSserv.getTrainers());
    }

    @GetMapping(path = "/{trainerId}")
    public ResponseEntity<List<Trainer>> getTrainers(@PathVariable String trainerId) {
        return ResponseEntity.ok(SRSserv.getTrainers());
    }
}
