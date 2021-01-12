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
	
	@Autowired
	public CompleteBatchDataController(RestTemplate restTemplateParam){
        restTemplate = restTemplateParam;
	}


	@GetMapping(path = "/{batchId}")
	public ResponseEntity<CompleteBatch> getCompleteBatchDataById(@PathVariable String batchId)
	{ 
		CompleteBatch result = new CompleteBatch();
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PartialBatch pBatch;
		QCNote[] qcNotes;
		AssessmentLocal[] assessLocals;
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		String assessJSON = restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/evaluation/assessments?batchId=" + batchId , HttpMethod.GET, entity, String.class).getBody();
		String QCJSON = restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/qa/notes/batch/"+batchId, HttpMethod.GET, entity, String.class).getBody();
		String batchJSON = restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/training/batch/"+batchId, HttpMethod.GET, entity, String.class).getBody();
		try {
			pBatch = mapper.readValue(batchJSON, PartialBatch.class);
			qcNotes = mapper.readValue(QCJSON, QCNote[].class);
			assessLocals = mapper.readValue(assessJSON, AssessmentLocal[].class);
			
			for(QCNote note : qcNotes)
			{
				String QCcategoriesJSON = restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/qa/category/" 
						+ batchId + "/" + note.week, HttpMethod.GET, entity, String.class).getBody();
				if(QCcategoriesJSON != null)
				{
					QCCategory[] qcCategories = mapper.readValue(QCcategoriesJSON, QCCategory[].class);
					note.categories = qcCategories;
					
				}
				else
				{
					note.categories = new QCCategory[0];
				}
			}
			
			for (AssessmentLocal assess : assessLocals)
			{
				String assessCategoryJSON = restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/category/category/" + assess.assessmentCategory, HttpMethod.GET, entity, String.class).getBody();
				
				assess.skillCategory = mapper.readValue(assessCategoryJSON, SkillCategory.class).skillCategory;
				
			}
			
			for (AssessmentLocal assess : assessLocals)
			{
				assess.average = Double.parseDouble(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/evaluation/grades/average?assessment="
				    	+ assess.assessmentId, HttpMethod.GET, entity, String.class).getBody());
			}
			
			
			result.setBatchId(batchId);
			
			result.setCurrentWeek(pBatch.currentWeek);
			result.setEndDate(pBatch.endDate);
			result.setId(pBatch.id);
			result.setName(pBatch.name);
			result.setLocation(pBatch.location);
			result.setSkill(pBatch.skill);
			result.setStartDate(pBatch.startDate);
			result.setType(pBatch.type);
			HashSet<Object> QCSet = new HashSet<>();
			HashSet<Object> assessSet = new HashSet<>();
			
			for(QCNote n : qcNotes)
			{
				QCSet.add(n);
			}
			for(AssessmentLocal a : assessLocals)
			{
				assessSet.add(a);
			}
			result.setQCNotes(QCSet);
			result.setAssessments(assessSet);
			
			
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
