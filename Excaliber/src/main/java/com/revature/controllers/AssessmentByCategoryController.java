package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AssessmentByCategoryService;
import com.revature.tables.AssessmentByCategory;

@RestController
@RequestMapping(path = "/AssessmentByCategory")
public class AssessmentByCategoryController {
	private AssessmentByCategoryService ABCserv;
	
	@Autowired
	public AssessmentByCategoryController(AssessmentByCategoryService s) {
		ABCserv=s;
	}
	
	@GetMapping
	public ResponseEntity<AssessmentByCategory> getABCTable(){
		return ResponseEntity.ok(ABCserv.getABCTable(1));
	}

}
