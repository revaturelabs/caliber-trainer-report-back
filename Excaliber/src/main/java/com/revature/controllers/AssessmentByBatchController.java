package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AssessmentByBatchService;
import com.revature.tables.AssessmentByBatch;



@RestController
@RequestMapping(path = "/AssessmentByBatch")
public class AssessmentByBatchController {
	private AssessmentByBatchService aBBserv;
	
	@Autowired
	public AssessmentByBatchController(AssessmentByBatchService a) {
		aBBserv=a;
	}
	
	@GetMapping
	public ResponseEntity<List<AssessmentByBatch>> getABBTable(){
		return ResponseEntity.ok(aBBserv.getABBTable(1));
	}

}
