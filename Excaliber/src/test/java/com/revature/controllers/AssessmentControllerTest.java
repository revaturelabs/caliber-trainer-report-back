package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;      
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.revature.Excaliber;

@SpringBootTest(classes=Excaliber.class)
public class AssessmentControllerTest {
	
	@Autowired
	static MockMvc mockMvc;
	
	@BeforeAll
	public static void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(AssessmentController.class).build();
	}
	
	@Test
	public void testGetAssessmentByBatchIdAndWeek() throws Exception {
		MvcResult result = mockMvc.perform(get("/Assessment/assessments/{batch}/{week}", "TR-1345", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();		
		
		System.out.println(result.getResponse().getContentAsString());
	}
	/*
	@Test
	public void testGetAverageAssessmentGrade() throws Exception {
		MvcResult result = mockMvc.perform(get("/Assessment/assessment/grade/{assessmentId}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();
				
		System.out.println(result.getResponse().getContentAsString());

	}
	*/
}