package com.revature.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AssessScoresByCategoryAllBatches_Service;
import com.revature.tables.AssessScoresByCategoryAllBatches;

@RestController
@CrossOrigin(origins ="http://localhost:4200", allowCredentials = "true")
@RequestMapping(path="/assessscoresbycatergoryallbatches")
public class AssessScoresByCategoryAllBatches_Controller {
	public Logger log = Logger.getLogger(TechnicalStatusByWeek_Controller.class);
	private AssessScoresByCategoryAllBatches_Service catAll;

	@Autowired
	public AssessScoresByCategoryAllBatches_Controller(AssessScoresByCategoryAllBatches_Service a)
	{
		catAll = a;
	}
	
	@GetMapping(path = "/{category}")
	public ResponseEntity<AssessScoresByCategoryAllBatches> getScoresByCategoryAllBatches(@PathVariable("category") String category)
	{
		log.trace("Getting table data for AssessScoresByCategoryAllBatches/" + category);
		AssessScoresByCategoryAllBatches batches = new AssessScoresByCategoryAllBatches();
		batches = catAll.getAssessScoresByCategoryAllBatches(category);
		return ResponseEntity.ok(batches);
	}
}
