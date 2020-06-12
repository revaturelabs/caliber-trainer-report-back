package com.revature.controllers;

<<<<<<< HEAD
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.TechnicalStatusPerBatch_Service;
import com.revature.tables.TechnicalStatusPerBatch;

@RestController
@RequestMapping(path = "/TechnicalStatusPerBatch")
public class TechnicalStatusPerBatch_Controller {
	
	private Logger logger = Logger.getLogger(TechnicalStatusPerBatch_Controller.class);
	
	private TechnicalStatusPerBatch_Service techStatPerBatchService;
	
	@Autowired
	public TechnicalStatusPerBatch_Controller(TechnicalStatusPerBatch_Service techStatService) {
		techStatPerBatchService = techStatService;
	}
	
	@GetMapping(path = "/{{batchId}}")
	public ResponseEntity<List<TechnicalStatusPerBatch>> getTable(@PathVariable("batchId") String batchID){
		List<TechnicalStatusPerBatch> dataPoints = techStatPerBatchService.getDataPoints(batchID);
		
		if (dataPoints.size() > 0 && dataPoints != null) {
			logger.trace("____GENERATING LIST OF DATA POINTS BY BATCH ID____");
			logger.trace("Data Points = " + dataPoints + " Batch ID = " + batchID);
			}
			else if (dataPoints.size() == 0 || dataPoints == null) {
				
				logger.warn("____LIST HAS A SIZE OF ZERO, OR IS NULL____");
				logger.warn("Data Points = " + dataPoints + " Batch ID = " + batchID);
			}
		
		return ResponseEntity.ok(dataPoints);
	}

=======
import com.revature.services.TechnicalStatusPerBatch_Service;
import com.revature.tables.TechnicalStatusPerBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/TechnicalStatusPerBatch")
public class TechnicalStatusPerBatch_Controller {

    private final TechnicalStatusPerBatch_Service tServ;

    @Autowired
    public TechnicalStatusPerBatch_Controller(TechnicalStatusPerBatch_Service t) {

        this.tServ = t;
    }

    @GetMapping
    public ResponseEntity<TechnicalStatusPerBatch> getTechnicalStatusPerBatch() {
        return ResponseEntity.ok(this.tServ.returnTable(1));
    }
>>>>>>> c00a915f3d15d598ceee9f640c497a2d7ce01169
}
