package com.revature.controllers;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.revature.Excaliber;



@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class QCNotesControllerTest {
	MockMvc mvc;
	
	@MockBean
	private RestTemplate restTemplate;
	
    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        // this.mvc.perform(RestDocumentationRequestBuilders.get("/QCNote"));
    }
    
    @AfterEach
    void tearDown() {
    }

	@Test
	void getQCNotesByBatchID() throws Exception{ 
		
		
		HttpEntity<String> myEntity = new HttpEntity<>("Nice");
		String response = "Response";
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
        
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);
		
		mvc.perform(RestDocumentationRequestBuilders.get("/QCNote/qcNotes/{id}","SUPER REAL GROUP"))
        .andExpect(status().isOk())
        .andDo(document("QCNote/qcNotes/TR-1142"));
	}
	@Test
	void getCategoryByWeekTest() throws Exception{ 
	
		HttpEntity<String> myEntity = new HttpEntity<>("Nice");
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
		
		Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);

		mvc.perform(get("/QCNote/qcNote/{batch}/category/{week}","TR-1142",2))
        .andExpect(status().isOk());
		
	}
	

}