package com.revature.services;




import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.TechnicalStatusPerBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * The type Technical status per batch service.
 */
@Service
public class TechnicalStatusPerBatchService {

    private final StoreRetrieveService sRSserv;

    /**
     * Instantiates a new Technical status per batch service.
     *
     * @param s the s
     */
    @Autowired
    public TechnicalStatusPerBatchService(StoreRetrieveService s) {
        this.sRSserv = s;
    }

    /**
     * Technical status per batch table technical status per batch.
     *
     * @param id the id
     * @return technical status per batch
     */
    public TechnicalStatusPerBatch technicalStatusPerBatchTable(int id) {
        Trainer trainer = sRSserv.getTrainerById(id);
        TechnicalStatusPerBatch table = new TechnicalStatusPerBatch();
        ArrayList<String> batchIds = new ArrayList<String>();

        ArrayList<String> batchName = new ArrayList<String>();
        ArrayList<int[]> techStatus = new ArrayList<int[]>();
        for (Batch b : trainer.getBatches()) {
            batchIds.add(b.getBatchId());
            batchName.add(b.getBatchName());
            int poor = 0;
            int good = 0;
            int average = 0;
            int superstar = 0;
            int n = 0;
            for (Week w : b.getWeeks()) {
                if (w.getTechnicalStatus() != null) {
                    if (w.getTechnicalStatus().contains("Good")) {
                        good++;
                    } else if (w.getTechnicalStatus().contains("Average")) {
                        average++;
                    } else if (w.getTechnicalStatus().contains("Poor")) {
                        poor++;
                    } else if (w.getTechnicalStatus().contains("Superstar")) {

                        superstar++;
                    } else if (w.getTechnicalStatus().contains("null")) {
                        n++;
                    }
                }// end if

            }// end week for loop
            int[] counts = {poor, average, good, superstar, n};
            techStatus.add(counts);
        } // end batch for loop

        table.setBatchId(batchIds);
        table.setBatchName(batchName);
        table.setTechnicalStatus(techStatus);
        return table;
    }// end of method

} // end class

