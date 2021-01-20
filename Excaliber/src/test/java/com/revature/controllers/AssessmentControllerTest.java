package com.revature.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.revature.Excaliber;
import com.revature.beans.Batch;
import com.revature.beans.CompleteBatch;


@SpringBootTest(classes=Excaliber.class)

@AutoConfigureMockMvc

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class AssessmentControllerTest {
    MockMvc mvc;

	@MockBean
	RestTemplate restTemplate;
	
	
	   @BeforeEach
	    public void setUp(WebApplicationContext webApplicationContext,
	                      RestDocumentationContextProvider restDocumentation) throws Exception {
	        this.mvc = MockMvcBuilders
	                .webAppContextSetup(webApplicationContext)
	                .apply(documentationConfiguration(restDocumentation))
	                .build();
	        this.mvc.perform(RestDocumentationRequestBuilders.get("/AssessmentController"));
	    }
	
	@Test
	void testgetAssessmentsByBatchIdAndWeek() throws Exception {
		
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
        
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);
		
		this.mvc.perform(RestDocumentationRequestBuilders.get("/Assessment/assessments/{batch}/{week}","1","1"))
        .andExpect(status().isOk());
	}

	@Test
	void testgetAverageAssessmentGradeById() throws Exception {
		
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
        
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);
		
		this.mvc.perform(RestDocumentationRequestBuilders.get("/Assessment/assessment/grade/{assessmentId}","1"))
		.andExpect(status().isOk());
	}
}
