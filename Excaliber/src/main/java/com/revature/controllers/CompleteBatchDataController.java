package com.revature.controllers;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Batch;
import com.revature.beans.CompleteBatch;

@RestController
@RequestMapping(path = "/Complete/Batch")
public class CompleteBatchDataController {
	private BatchController batchCont = new BatchController();
	private QCNoteController QCCont = new QCNoteController();
	private AssessmentController assessCont = new AssessmentController();
	
	private class PartialBatch
	{
		public Integer id;
		public String batchId;
		public String startDate;
		public String endDate;
		public String skill;
		public String location;
		public String type;
		public Integer currentWeek;
	}
	
	private class QCNote
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
		public String[] categories;
	}
	
	private class AssessmentLocal
	{
		public Integer assessmentId;
		public Integer assessmentCategory;
		public String assessmentTitle;
		public String assessmentType;
		public String assignmentDate;
		public String batchId;
		public Integer rawScore;
		public Integer weekNumber;
	}
	
	
	@GetMapping(path = "/{batchId}")
	public ResponseEntity<CompleteBatch> getCompleteBatchDataById(@PathVariable String batchId)
	{
		ObjectMapper mapper = new ObjectMapper();
		PartialBatch pBatch;
		String batchJSON = batchCont.getBatchById("" +batchId);
		try {
			mapper.readValue(batchJSON, PartialBatch.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String QCJSON = QCCont.getQCNotesByBatchId(batchId);
		
		String assessJSON = assessCont.getAssessmentsByBatchIdAndWeek(""+batchId, 1);
		return null;
	}

}
