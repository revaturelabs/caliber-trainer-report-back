package com.revature.services;

import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * The type Table service.
 */
@Service
public class TableService {

    //load DAO
    private final StoreRetrieveService SRSserv;

    /**
     * Instantiates a new Table service.
     *
     * @param srSserv the sr sserv
     */
    @Autowired
    public TableService(StoreRetrieveService srSserv) {
        SRSserv = srSserv;
    }

    /**
     * Technical status per batch table technical status per batch.
     *
     * @param id the id
     * @return technical status per batch
     */
    public TechnicalStatusPerBatch technicalStatusPerBatchTable(int id) {
        Trainer trainer = SRSserv.getTrainerById(id);
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

    /**
     * Technical status by week table technical status by week.
     *
     * @param trainer_id the trainer id
     * @return technical status by week
     */
    public TechnicalStatusByWeek technicalStatusByWeekTable(int trainer_id) {
        return null;
    }

    /**
     * Batch technical status table batch technical status.
     *
     * @param trainer_id the trainer id
     * @return batch technical status
     */
    public BatchTechnicalStatus batchTechnicalStatusTable(int trainer_id) {
        return null;
    }

    /**
     * Assess scores by category all batches table assess scores by category all batches.
     *
     * @param trainer_id the trainer id
     * @return assess scores by category all batches
     */
    public AssessScoresByCategoryAllBatches assessScoresByCategoryAllBatchesTable(int trainer_id) {
        return null;
    }

    /**
     * Assessment by category table assessment by category.
     *
     * @param trainer_id the trainer id
     * @return assessment by category
     */
    public AssessmentByCategory assessmentByCategoryTable(int trainer_id) {
        return null;
    }

    /**
     * Assessment by batch table assessment by batch.
     *
     * @param trainer_id the trainer id
     * @return assessment by batch
     */
    public AssessmentByBatch assessmentByBatchTable(int trainer_id) {
        return null;
    }
}
