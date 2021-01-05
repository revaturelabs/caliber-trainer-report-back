package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Batch;
import com.revature.beans.CompleteBatch;

@RestController
@RequestMapping(path = "/Complete/Batch")
public class CompleteBatchDataController {
	
	@GetMapping(path = "/{batchId}")
	public ResponseEntity<CompleteBatch> getCompleteBatchDataById(@PathVariable int batchId)
	{
		//Test ME!!!!
		return null;
	}

}
