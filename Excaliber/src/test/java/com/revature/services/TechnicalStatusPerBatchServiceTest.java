package com.revature.services;

import com.revature.controllers.JSONController;
import com.revature.tables.TechnicalStatusPerBatch;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
        // to manage the session
class TechnicalStatusPerBatchServiceTest {

    private final TechnicalStatusPerBatchService tspbServ; // class being tested
    private final JSONController jCtrl; // for access to getTrainer2() method used for initializing data

    @Autowired
    public TechnicalStatusPerBatchServiceTest(TechnicalStatusPerBatchService t, JSONController c) {
        tspbServ = t;
        jCtrl = c;
    }

    /*
     *  Integration Test:
     *    -Method being Tested: TechnicalStatusPerBatchService.technicalStatusPerBatchTable()
     *      -Should return a List of TechnicalStatusPerBatch objects
     *    -Dependency: JSONController.getTrainer2()
     *      -Initializes Trainer data to be processed by the method
     */
    @Test
    void technicalStatusPerBatchTableTest() throws Exception {

        jCtrl.getTrainer2(); // initialize data

        // call technicalStatusPerBatchTable() and get returned list
        List<TechnicalStatusPerBatch> result = tspbServ.technicalStatusPerBatchTable(1);

        // check if returned list contains TechnicalStatusPerBatch objects
        assertTrue(result.get(0) instanceof TechnicalStatusPerBatch);
    }
}
