package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.TechnicalStatusPerBatchDAO;
import com.revature.tables.TechnicalStatusPerBatch;

@Service
public class TechnicalStatusByBatch_Service {
	
	TechnicalStatusPerBatchDAO dao;
	
	
	@Autowired
	public TechnicalStatusByBatch_Service(TechnicalStatusPerBatchDAO techStatDAO) {
		
		dao = techStatDAO;
	}
	
	public List<TechnicalStatusPerBatch> getDataPoints(String batchID){
		
		return dao.getDataPoints(batchID);
	}

}
