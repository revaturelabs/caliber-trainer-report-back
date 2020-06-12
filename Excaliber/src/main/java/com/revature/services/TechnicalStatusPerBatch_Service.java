package com.revature.services;

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
