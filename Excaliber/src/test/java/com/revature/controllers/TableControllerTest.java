package com.revature.controllers;

import com.revature.services.*;
import com.revature.tables.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TableController.class)
class TableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TechnicalStatusPerBatchService statusPerBatchService;
    @MockBean
    private TechnicalStatusByWeekService statusByWeekService;
    @MockBean
    private BatchTechnicalStatusBySkillCategoryService technicalStatusBySkillCategoryService;
    @MockBean
    private AssessScoresByCategoryAllBatchesService scoresByCategoryService;
    @MockBean
    private AssessmentByCategoryService assessmentByCategoryService;
    @MockBean
    private AssessmentByBatchService assessmentByBatchService;
    MockMvc mvc;
    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) throws Exception {
    }


    @Test
    void getTechnicalStatusPerBatch() throws Exception {
        List<TechnicalStatusPerBatch> table = new ArrayList<TechnicalStatusPerBatch>();;
        TechnicalStatusPerBatch technicalStatusPerBatch = new TechnicalStatusPerBatch();
        table.add(technicalStatusPerBatch);
        when(statusPerBatchService.technicalStatusPerBatchTable(1)).thenReturn(table);

        MvcResult result = mockMvc.perform(get("/{trainerId}/TechnicalStatusPerBatch/", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void getTechnicalStatusPerBatchNotFound() throws Exception {
        when(statusPerBatchService.technicalStatusPerBatchTable(1)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/{trainerId}/TechnicalStatusPerBatch/", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    void getAssessmentByBatch() throws Exception {
        List<AssessmentByBatch> table = new ArrayList<AssessmentByBatch>();
        AssessmentByBatch assessmentByBatch = new AssessmentByBatch();
        table.add(assessmentByBatch);
        when(assessmentByBatchService.getABBTable(1)).thenReturn(table);

        MvcResult result = mockMvc.perform(get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    @Test
    void getAssessmentByBatchNotFound() throws Exception {
        when(assessmentByBatchService.getABBTable(1)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/{trainerId}/AssessmentByBatch/", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void getAssessmentByCategory() throws Exception{
        List<AssessmentByCategory> table = new ArrayList<AssessmentByCategory>();
        AssessmentByCategory assessmentByCategory = new AssessmentByCategory();
        table.add(assessmentByCategory);
        when(assessmentByCategoryService.getABCTable(1)).thenReturn(table);

        MvcResult result = mockMvc.perform(get("/{trainerId}/AssessmentByCategory/", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void getAssessmentByCategoryNotFound() throws Exception{
        when(assessmentByCategoryService.getABCTable(1)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/{trainerId}/AssessmentByCategory/", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void getAssessScoresByCategoryAllBatches() throws Exception {
        AssessScoresByCategoryAllBatches batches = new AssessScoresByCategoryAllBatches();
        when(scoresByCategoryService.getAssessScoresByCategoryAllBatches(1)).thenReturn(batches);

        MvcResult result = mockMvc.perform(get("/{trainerId}/AssessScoresByCategoryAllBatches/", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void getAssessScoresByCategoryAllBatchesNotFound() throws Exception {
        when(scoresByCategoryService.getAssessScoresByCategoryAllBatches(1)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/{trainerId}/AssessScoresByCategoryAllBatches/", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void getTechnicalStatusByWeek() throws Exception {
        List<TechnicalStatusByWeek> table = new ArrayList<TechnicalStatusByWeek>();
        TechnicalStatusByWeek technicalStatusByWeek = new TechnicalStatusByWeek();
        table.add(technicalStatusByWeek);
        when(statusByWeekService.getTechnicalStatusByWeek(1)).thenReturn(table);

        MvcResult result = mockMvc.perform(get("/{trainerId}/TechnicalStatusByWeek/", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void getTechnicalStatusByWeekNotFound() throws Exception {
        when(statusByWeekService.getTechnicalStatusByWeek(1)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/{trainerId}/TechnicalStatusByWeek/", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void getTableDataObject() throws Exception{
        BatchTechnicalStatusBySkillCategory batchTechnicalStatusBySkillCategory = new BatchTechnicalStatusBySkillCategory();
        when(technicalStatusBySkillCategoryService.getTableData(1)).thenReturn(batchTechnicalStatusBySkillCategory);

        MvcResult result = mockMvc.perform(get("/{trainerId}/BatchTechnicalStatusBySkillCategory/", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void getTableDataObjectNotFound() throws Exception{
        when(technicalStatusBySkillCategoryService.getTableData(1)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/{trainerId}/BatchTechnicalStatusBySkillCategory/", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}

