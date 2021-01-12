package com.revature.services;




import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.TechnicalStatusPerBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Technical status per batch service.
 */
@Service
public class StatusPerBatchService {

    private final StoreRetrieveService sRSserv;

    /**
     * Instantiates a new Technical status per batch service.
     *
     * @param s the s
     */
    @Autowired
    public StatusPerBatchService(StoreRetrieveService s) {
        this.sRSserv = s;
    }

    /**
     * Technical status per batch table technical status per batch.
     *
     * @param id the id
     * @return technical status per batch
     */
    public List<TechnicalStatusPerBatch> technicalStatusPerBatchTable(int id) {
        Trainer trainer = sRSserv.getTrainerById(id);
        ArrayList<String> batchIds = new ArrayList<>();

        ArrayList<String> batchName = new ArrayList<>();
        ArrayList<int[]> techStatus = new ArrayList<>();
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


        List<TechnicalStatusPerBatch> table = generateTSPBTable(batchIds, batchName, techStatus);
        return table;
    }// end of method

    public List<TechnicalStatusPerBatch> generateTSPBTable(ArrayList<String> batchIds, ArrayList<String> batchName, ArrayList<int[]> techStatus) {
        ArrayList<TechnicalStatusPerBatch> table = new ArrayList<TechnicalStatusPerBatch>();

        for (int i = 0; i < batchIds.size(); i++) {
            TechnicalStatusPerBatch t = new TechnicalStatusPerBatch();
            t.setBatchId(batchIds.get(i));
            t.setBatchName(batchName.get(i));
            t.setTechnicalStatus(techStatus.get(i));
            table.add(t);
        }

        return table;
    }

} // end class

