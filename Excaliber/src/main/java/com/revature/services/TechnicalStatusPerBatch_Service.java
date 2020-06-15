package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalStatusPerBatch_Service {

    private final StoreRetrieveService SRSserv;

    @Autowired
    public TechnicalStatusPerBatch_Service(StoreRetrieveService s) {
        this.SRSserv = s;
    }



} // end class
