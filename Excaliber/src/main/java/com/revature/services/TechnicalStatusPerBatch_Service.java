package com.revature.services;

<<<<<<< HEAD
import java.util.List;


//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.TechnicalStatusPerBatchDAO;
import com.revature.tables.TechnicalStatusPerBatch;

@Service
public class TechnicalStatusPerBatch_Service {
	
//	private Logger logger = Logger.getLogger(TechnicalStatusPerBatch_Service.class);
	
	TechnicalStatusPerBatchDAO dao;
	
	
	@Autowired
	public TechnicalStatusPerBatch_Service(TechnicalStatusPerBatchDAO techStatDAO) {
		
		dao = techStatDAO;
	}
	
	public List<TechnicalStatusPerBatch> getDataPoints(String batchID){
		
//		List<TechnicalStatusPerBatch> dataPoints = dao.getDataPoints(batchID);
//		
//		if (dataPoints.size() > 0 && dataPoints != null) {
//			logger.trace("____GENERATING LIST OF DATA POINTS BY BATCH ID____");
//			logger.trace("Data Points = " + dataPoints + " Batch ID = " + batchID);
//			}
//			else if (dataPoints.size() == 0 || dataPoints == null) {
//				
//				logger.warn("____LIST HAS A SIZE OF ZERO, OR IS NULL____");
//				logger.warn("Data Points = " + dataPoints + " Batch ID = " + batchID);
//			}
		
		return dao.getDataPoints(batchID);
	}

}
=======
import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.TechnicalStatusPerBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TechnicalStatusPerBatch_Service {

    private final StoreRetrieveService SRSserv;

    @Autowired
    public TechnicalStatusPerBatch_Service(StoreRetrieveService s) {
        this.SRSserv = s;
    }

    public TechnicalStatusPerBatch returnTable(int id) {
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
                    }
                }// end if
                else {
                    n++;
                }
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
>>>>>>> c00a915f3d15d598ceee9f640c497a2d7ce01169
