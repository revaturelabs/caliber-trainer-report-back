package com.revature.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class TableControllerTest {

    MockMvc mvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) throws Exception {
        this.mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        this.mvc.perform(RestDocumentationRequestBuilders.get("/JSONController"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTechnicalStatusPerBatch() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }

    @Test
    void getAssessmentByBatch() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }

    @Test
    void getAssessmentByCategory() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }

    @Test
    void getAssessScoresByCategoryAllBatches() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }

    @Test
    void getBatchTechnicalStatus() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }

    @Test
    void getTechnicalStatusByWeek() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }

    @Test
    void testGetAssessmentByBatchShouldBe() throws Exception {
        this.mvc.perform(RestDocumentationRequestBuilders.get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andDo(document("1/AssessmentByBatch/",
                        pathParameters(parameterWithName("trainerId")
                                .description("Identifier of the trainer to be obtained."))
                ));
    }
}

