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
public class BatchControllerTest {
	

    MockMvc mvc;


    @Autowired
	@MockBean
	RestTemplate restTemplate;
	
	BatchController cont = new BatchController();
	
	   @BeforeEach
	    public void setUp(WebApplicationContext webApplicationContext,
	                      RestDocumentationContextProvider restDocumentation) throws Exception {
	        this.mvc = MockMvcBuilders
	                .webAppContextSetup(webApplicationContext)
	                .apply(documentationConfiguration(restDocumentation))
	                .build();
	        this.mvc.perform(RestDocumentationRequestBuilders.get("/BatchController"));
	    }
	@Test
	public void testgetEndpointBatchIdsByTrainerEmail() throws Exception {
		
		String email="mock6.associate6057581e-cb72-41ee-b387-897e3d139896@mock.com";
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
        
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);
		
		this.mvc.perform(RestDocumentationRequestBuilders.post("/Batch/batches/").content("mock1011.employeece2f8b79-da1c-44bc-8156-a65fd716987a@mock.com"))
        .andExpect(status().isOk())
        .andDo(document("Batch/batches/mock1011.employeece2f8b79-da1c-44bc-8156-a65fd716987a@mock.com"));
	}
	
	@Test
	public void testgetBatchById() throws Exception {
		String id ="296";
		///Batch b= cont.getBatchById(id);

		HttpEntity<String> myEntity = new HttpEntity<>("Nice");
		String response = "Response";
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
        
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);
		
		this.mvc.perform(RestDocumentationRequestBuilders.get("/Batch/batch/{id}","296"))
        .andExpect(status().isOk())
        .andDo(document("Batch/batch/296"));
	}
	
	
}
