package com.revature.data;

import com.revature.tables.TechnicalStatusPerBatch;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;



@ExtendWith(MockitoExtension.class)
class TechnicalStatusPerBatchDAOTest {
	private final Logger logger = Logger.getLogger(TechnicalStatusPerBatchDAOTest.class);

TechnicalStatusPerBatch techStatCLASS;

//@Nested
//class JsonParse{
//	
//	
//	if (dataPoints.size() > 0 && dataPoints != null) {
//		logger.trace("____GENERATING LIST OF DATA POINTS BY BATCH ID____");
//		logger.trace("Data Points = " + dataPoints + " Batch ID = " + batchID);
//		}
//		else if (dataPoints.size() == 0 || dataPoints == null) {
//			
//			logger.warn("____LIST HAS A SIZE OF ZERO, OR IS NULL____");
//			logger.warn("Data Points = " + dataPoints + " Batch ID = " + batchID);
//		}
//	 
//	
//}


	
	public List<TechnicalStatusPerBatch> getDataPoints(String batchID){
		
		List<TechnicalStatusPerBatch> dataPoints = null;
		
		
		dataPoints = new ArrayList<TechnicalStatusPerBatch>();
		
		dataPoints.add(new TechnicalStatusPerBatch());
		
		
		
		return dataPoints;
	}
}
