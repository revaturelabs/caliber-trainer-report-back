package com.revature.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.TechnicalStatusByWeek_Service;
import com.revature.tables.TechnicalStatusByWeek;

@RestController
@CrossOrigin(origins ="http://localhost:4200", allowCredentials = "true")
@RequestMapping(path="/TechnicalStatusByWeek")

public class TechnicalStatusByWeek_Controller {
	private TechnicalStatusByWeek_Service serv;
	public Logger log = Logger.getLogger(TechnicalStatusByWeek_Controller.class);
	
	@Autowired
	public TechnicalStatusByWeek_Controller(TechnicalStatusByWeek_Service s) {
		serv = s;
	}
	
	// Handles Get request to /TechnicalStatusByWeek/{batch id}
	// and returns List<TechnicalStatusByWeek> in response body
	@GetMapping(path = "/{batchId}")
	public ResponseEntity<List<TechnicalStatusByWeek>> getTableData(@PathVariable("batchId") String batchId){
		log.info("TechnicalStatusByWeek_Controller: "
				+ "Getting table data for TechnicalStatusByWeek/" + batchId);
		List<TechnicalStatusByWeek> tableObjects = serv.getTableData(batchId);
		return ResponseEntity.ok(tableObjects);
	}
	
}
