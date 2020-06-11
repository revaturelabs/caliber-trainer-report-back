package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.TechnicalStatusByBatch_Service;
import com.revature.tables.TechnicalStatusPerBatch;

@RestController
@RequestMapping(path = "/TechnicalStatusPerBatch")
public class TechnicalStatusPerBatch_Controller {
	
	private TechnicalStatusByBatch_Service techStatPerBatchService;
	
	@Autowired
	public TechnicalStatusPerBatch_Controller(TechnicalStatusByBatch_Service techStatService) {
		techStatPerBatchService = techStatService;
	}
	
	@GetMapping(path = "/{{batchId}}")
	public ResponseEntity<List<TechnicalStatusPerBatch>> getTable(@PathVariable("batchId") String batchID){
		List<TechnicalStatusPerBatch> dataPoints = techStatPerBatchService.getDataPoints(batchID);
		
		return ResponseEntity.ok(dataPoints);
	}

}
