package com.revature.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Batch;
import com.revature.beans.CompleteBatch;
import com.revature.services.BatchService;

@RestController
@RequestMapping(path = "/Complete/Batch")
public class CompleteBatchDataController {
	
	
	private static class PartialBatch
	{
		public Integer id;
		public String batchId;
		public String startDate;
		public String endDate;
		public String skill;
		public String location;
		public String type;
		public Integer currentWeek;
		public String name;
		public Integer goodGrade;
		public Integer passingGrade;
	}
	
	private static class SkillCategory
	{
		public boolean active;
		public Integer categoryId;
		public String skillCategory;
	}
	
	private static class QCCategory
	{
		public String batchId;
		public Integer categoryId;
		public Integer id;
		public String skillCategory;
		public Integer week;
	}
	
	private static class QCNote
	{
		/*
		 * noteId : number;
    	content : string;
   		week : number;
    	batchId : string;
    	associateId : string;
    	employeeId : string;
    	type : string;
    	technicalStatus : string;
    	createdOn : string;
    	lastUpdated : string;
    	categories : string[];
		*/
		
		public Integer noteId;
		public String content;
		public Integer week;
		public String batchId;
		public String associateId;
		public String employeeId;
		public String type;
		public String technicalStatus;
		public String createdOn;
		public QCCategory[] categories;
	}
	
	private static class AssessmentLocal
	{
		public Integer assessmentId;
		public Integer assessmentCategory;
		public String assessmentTitle;
		public String assessmentType;
		public String assignmentDate;
		public String batchId;
		public Integer rawScore;
		public Integer weekNumber;
		public Double average;
		public String skillCategory;
	}
	
	private final RestTemplate restTemplate;
	private final BatchService batchService;

	@Autowired
	public CompleteBatchDataController(RestTemplate restTemplateParam, BatchService batchServiceParam){
        restTemplate = restTemplateParam;
        batchService = batchServiceParam;
	}


	@GetMapping(path = "/{batchId}")
	public ResponseEntity<CompleteBatch> getCompleteBatchDataById(@PathVariable String batchId)
	{ 
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		CompleteBatch result = new CompleteBatch();

		try {
		    result = batchService.getCompleteBatchDataById(batchId, mapper);
		
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

		
		return ResponseEntity.ok(result);
	}

}
