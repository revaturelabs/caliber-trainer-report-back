package com.revature.controllers;

import com.revature.services.StoreRetrieveService;
import com.revature.utils.ParseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final StoreRetrieveService SRSserv;

    @Autowired
    public MainController(StoreRetrieveService s) {
        SRSserv = s;
    }

    public void storeTrainer() {
        ParseJSON ps = new ParseJSON();
        String fileName = "data.json";
        ParseJSON.readDataFromFile(fileName);
    }
}
