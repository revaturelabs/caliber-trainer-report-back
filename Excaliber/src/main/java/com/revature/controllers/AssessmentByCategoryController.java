package com.revature.controllers;

import com.revature.services.AssessmentByCategoryService;
import com.revature.tables.AssessmentByCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Assessment by category controller.
 */
@RestController
@RequestMapping(path = "/AssessmentByCategory")
public class AssessmentByCategoryController {
	private final AssessmentByCategoryService ABCserv;

	/**
	 * Instantiates a new Assessment by category controller.
	 *
	 * @param s the s
	 */
	@Autowired
	public AssessmentByCategoryController(AssessmentByCategoryService s) {
		ABCserv = s;
	}

	/**
	 * Get abc table response entity.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<AssessmentByCategory> getABCTable() {
		return ResponseEntity.ok(ABCserv.getABCTable(1));
	}

}
