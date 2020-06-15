package com.revature.controllers;

import com.revature.services.BatchTechnicalStatusBySkillCategoryService;
import com.revature.tables.BatchTechnicalStatusBySkillCategory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Batch technical status by skill category controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(path = "/BatchTechnicalStatusBySkillCategory")
public class BatchTechnicalStatusBySkillCategoryController {
	private final BatchTechnicalStatusBySkillCategoryService tsbscServ;

	/**
	 * The Log.
	 */
	public Logger log = Logger.getLogger(BatchTechnicalStatusBySkillCategoryController.class);

	/**
	 * Instantiates a new Batch technical status by skill category controller.
	 *
	 * @param serv the serv
	 */
	@Autowired
	public BatchTechnicalStatusBySkillCategoryController(BatchTechnicalStatusBySkillCategoryService serv) {
		tsbscServ = serv;
	}

	/**
	 * Get table data object response entity.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<BatchTechnicalStatusBySkillCategory>> getTableDataObject() {
		log.info("Retriving graph table data for get request ");
		List<BatchTechnicalStatusBySkillCategory> graphTableObjects = tsbscServ.getTableData();
		return ResponseEntity.ok(graphTableObjects);
	}

}
