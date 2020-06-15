package com.revature.data;

import com.revature.tables.TechnicalStatusPerBatch;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicalStatusPerBatchDAO {

    private final Logger logger = Logger.getLogger(TechnicalStatusPerBatchDAO.class);

    public List<TechnicalStatusPerBatch> getDataPoints(String batchID) {

        List<TechnicalStatusPerBatch> dataPoints = null;

        if (dataPoints.size() > 0 && dataPoints != null) {
            logger.trace("____GENERATING LIST OF DATA POINTS BY BATCH ID____");
            logger.trace("Data Points = " + dataPoints + " Batch ID = " + batchID);
        } else if (dataPoints.size() == 0 || dataPoints == null) {

            logger.warn("____LIST HAS A SIZE OF ZERO, OR IS NULL____");
            logger.warn("Data Points = " + dataPoints + " Batch ID = " + batchID);
        }

        return dataPoints;
    }

}
