package com.revature.utils;

import com.revature.beans.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static com.revature.utils.LoggerSingleton.getLogger;


/**
 * The type Parse json.
 */
public class ParseJSON {
    private static String json = "{\r\n" +
            "  \"employee\": {\r\n" +
            "    \"email\": \"james.gosling@revature.com\",\r\n" +
            "    \"firstName\": \"James\",\r\n" +
            "    \"lastName\": \"Gosling\"\r\n" +
            "  },\r\n" +
            "  \"batches\": [\r\n" +
            "    {\r\n" +
            "      \"id\": 121501,\r\n" +
            "      \"batchId\": \"Ix2x2UAB\",\r\n" +
            "      \"name\": \"1804  Apr16 -2\",\r\n" +
            "      \"startDate\": \"2018-04-23\",\r\n" +
            "      \"endDate\": \"2018-06-29\",\r\n" +
            "      \"skill\": \"JTA\",\r\n" +
            "      \"location\": \"Revature LLC, Reston VA 20190\",\r\n" +
            "      \"type\": \"Revature\",\r\n" +
            "      \"qcNotes\": [\r\n" +
            "        {\r\n" +
            "          \"noteId\": 398328,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 1,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 399329,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 2,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"SQL\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 401138,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 3,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"JavaScript\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 404094,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 4,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Servlet\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 405119,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 5,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"AWS\",\r\n" +
            "            \"Hibernate\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 407113,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 6,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Testing\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 409140,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 7,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"REST\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 410118,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 8,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        }\r\n" +
            "      ],\r\n" +
            "      \"assessments\": [\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 177003,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 1,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 76.10\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 177004,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 1,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 81.35\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 177023,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 2,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 2,\r\n" +
            "          \"skillCategory\": \"SQL\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 85.83\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 177024,\r\n" +
            "          \"rawScore\": 50,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 2,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 2,\r\n" +
            "          \"skillCategory\": \"SQL\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 82.31\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 177025,\r\n" +
            "          \"rawScore\": 50,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Presentation\",\r\n" +
            "          \"weekNumber\": 2,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 2,\r\n" +
            "          \"skillCategory\": \"SQL\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 83.08\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 178000,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 12,\r\n" +
            "          \"skillCategory\": \"JavaScript\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 71.35\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 178001,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 12,\r\n" +
            "          \"skillCategory\": \"JavaScript\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 80.58\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 179012,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 68.81\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 179018,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Presentation\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 75.77\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 180007,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 18,\r\n" +
            "          \"skillCategory\": \"Hibernate\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 76.35\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 180008,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 16,\r\n" +
            "          \"skillCategory\": \"AWS\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 81.65\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 180016,\r\n" +
            "          \"rawScore\": 200,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 18,\r\n" +
            "          \"skillCategory\": \"Hibernate\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 81.15\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 180025,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 6,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 31,\r\n" +
            "          \"skillCategory\": \"Testing\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 73.38\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 180026,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 6,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 31,\r\n" +
            "          \"skillCategory\": \"Testing\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 77.69\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 181002,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 21,\r\n" +
            "          \"skillCategory\": \"REST\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 72.52\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 181004,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"Ix2x2UAB\",\r\n" +
            "          \"assessmentCategory\": 21,\r\n" +
            "          \"skillCategory\": \"REST\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 80.38\r\n" +
            "        }\r\n" +
            "      ]\r\n" +
            "    },\r\n" +
            "    {\r\n" +
            "      \"id\": 138502,\r\n" +
            "      \"batchId\": \"2rUNwAAM\",\r\n" +
            "      \"name\": \"1901 Jan06 Other\",\r\n" +
            "      \"startDate\": \"2019-01-10\",\r\n" +
            "      \"endDate\": \"2019-03-18\",\r\n" +
            "      \"skill\": \"OTHER\",\r\n" +
            "      \"location\": \"Revature LLC, Reston VA 20190\",\r\n" +
            "      \"type\": \"Revature\",\r\n" +
            "      \"qcNotes\": [\r\n" +
            "        {\r\n" +
            "          \"noteId\": 447435,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 1,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 448409,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 2,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"SQL\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 450431,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 3,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": null,\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"JavaScript\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 450436,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 4,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Servlet\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 451465,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 5,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Agile\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 451797,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 6,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 453356,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 7,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 453777,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 8,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        }\r\n" +
            "      ],\r\n" +
            "      \"assessments\": [\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 202081,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"1901 PE Week1\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 1,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 78.15\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 202096,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"1901_Jan07_PE_Week2\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 2,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 2,\r\n" +
            "          \"skillCategory\": \"SQL\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 82.45\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 203074,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"1901_Jan07_PE_Week3\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 12,\r\n" +
            "          \"skillCategory\": \"JavaScript\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 79.52\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 203140,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 76.20\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 203148,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Project\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 74.78\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 204078,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 30,\r\n" +
            "          \"skillCategory\": \"Agile\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 79.90\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 204079,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 30,\r\n" +
            "          \"skillCategory\": \"Agile\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 79.13\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 205079,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 6,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 67.53\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 206063,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 80.12\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 206064,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Presentation\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"2rUNwAAM\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 80.45\r\n" +
            "        }\r\n" +
            "      ]\r\n" +
            "    },\r\n" +
            "    {\r\n" +
            "      \"id\": 138523,\r\n" +
            "      \"batchId\": \"2rgIVAAY\",\r\n" +
            "      \"name\": \"1903 Mar04 Full Stack Java/JEE\",\r\n" +
            "      \"startDate\": \"2019-03-05\",\r\n" +
            "      \"endDate\": \"2019-06-01\",\r\n" +
            "      \"skill\": \"J2EE\",\r\n" +
            "      \"location\": \"Revature LLC, Reston VA 20190\",\r\n" +
            "      \"type\": \"Revature\",\r\n" +
            "      \"qcNotes\": [\r\n" +
            "        {\r\n" +
            "          \"noteId\": 455491,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 1,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"JavaScript\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 456593,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 2,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 458434,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 3,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 458631,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 4,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Poor\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"SQL\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 462403,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 5,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Poor\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Servlet\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 463517,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 6,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Poor\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Hibernate\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 464408,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 7,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 464844,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 8,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 465642,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 9,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Poor\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Spring\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 467383,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 10,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\",\r\n" +
            "            \"Microservices\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 467827,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 11,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        }\r\n" +
            "      ],\r\n" +
            "      \"assessments\": [\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 208060,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"1922-W3-HTML,CSS,JS\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 1,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 12,\r\n" +
            "          \"skillCategory\": \"JavaScript\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 80.38\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 212057,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"190401_Week1Java\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 81.62\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 212060,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"1901 jan28 week sql\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 2,\r\n" +
            "          \"skillCategory\": \"SQL\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 82.99\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 212062,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"0304-Week4-Servlets/Angular\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 78.97\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 212063,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"0304-Week5-Hibernate/DevOps/AWS\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 6,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 18,\r\n" +
            "          \"skillCategory\": \"Hibernate\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 72.58\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 212069,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 73.84\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 214082,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 9,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 19,\r\n" +
            "          \"skillCategory\": \"Spring\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 70.16\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 214083,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 9,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 19,\r\n" +
            "          \"skillCategory\": \"Spring\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 59.44\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 215087,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 10,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 38,\r\n" +
            "          \"skillCategory\": \"Microservices\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 74.21\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 215088,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Presentation\",\r\n" +
            "          \"weekNumber\": 10,\r\n" +
            "          \"batchId\": \"2rgIVAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 83.13\r\n" +
            "        }\r\n" +
            "      ]\r\n" +
            "    },\r\n" +
            "    {\r\n" +
            "      \"id\": 141512,\r\n" +
            "      \"batchId\": \"2ehKRAAY\",\r\n" +
            "      \"name\": \"1909 Sep30 Other\",\r\n" +
            "      \"startDate\": \"2019-10-01\",\r\n" +
            "      \"endDate\": \"2019-12-28\",\r\n" +
            "      \"skill\": \"OTHER\",\r\n" +
            "      \"location\": \"Revature LLC, Reston VA 20190\",\r\n" +
            "      \"type\": \"Revature\",\r\n" +
            "      \"qcNotes\": [\r\n" +
            "        {\r\n" +
            "          \"noteId\": 485015,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 1,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 485390,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 2,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 486389,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 3,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 488806,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 4,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\",\r\n" +
            "            \"SQL\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 489363,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 5,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Java\",\r\n" +
            "            \"JavaScript\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 490490,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 6,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Servlet\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 491500,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 7,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Servlet\",\r\n" +
            "            \"JVM\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 491974,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 8,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"JVM\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 493382,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 9,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"DevOps\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 493758,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 10,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Good\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": [\r\n" +
            "            \"Performance Testing\"\r\n" +
            "          ]\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 494723,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 11,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 500647,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 12,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Poor\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"noteId\": 501189,\r\n" +
            "          \"content\": \"mock content\",\r\n" +
            "          \"week\": 13,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"associateId\": null,\r\n" +
            "          \"employeeId\": null,\r\n" +
            "          \"type\": \"QC_BATCH\",\r\n" +
            "          \"technicalStatus\": \"Average\",\r\n" +
            "          \"createdOn\": null,\r\n" +
            "          \"lastUpdated\": null,\r\n" +
            "          \"categories\": []\r\n" +
            "        }\r\n" +
            "      ],\r\n" +
            "      \"assessments\": [\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 233060,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"Core Java extended - Blake\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 1,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 79.52\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 233061,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 1,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 83.13\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 233090,\r\n" +
            "          \"rawScore\": 75,\r\n" +
            "          \"assessmentTitle\": \"Java Exam\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 2,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 90.29\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 234068,\r\n" +
            "          \"rawScore\": 125,\r\n" +
            "          \"assessmentTitle\": \"Java Verbal\",\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 2,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 76.73\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 234084,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Other\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 91.20\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 235057,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"191007-W1-Core Java\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 77.98\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 235058,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 3,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 83.93\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 235064,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"SQL quiz\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 2,\r\n" +
            "          \"skillCategory\": \"SQL\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 89.02\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 236050,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Project\",\r\n" +
            "          \"weekNumber\": 4,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 80.80\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 236051,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": \"blake-client-side--copy\",\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 12,\r\n" +
            "          \"skillCategory\": \"JavaScript\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 83.17\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 236077,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 5,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 1,\r\n" +
            "          \"skillCategory\": \"Java\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 79.73\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 236099,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 6,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 73.04\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 237050,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 6,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 76.03\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 238061,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15081,\r\n" +
            "          \"skillCategory\": \"JVM\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 72.32\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 238062,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Project\",\r\n" +
            "          \"weekNumber\": 7,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 3,\r\n" +
            "          \"skillCategory\": \"Servlet\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 79.00\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 238075,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 8,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15081,\r\n" +
            "          \"skillCategory\": \"JVM\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 72.56\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 241053,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 8,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15081,\r\n" +
            "          \"skillCategory\": \"JVM\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 72.06\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 239059,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 9,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15071,\r\n" +
            "          \"skillCategory\": \"DevOps\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 70.81\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 241054,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 9,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15071,\r\n" +
            "          \"skillCategory\": \"DevOps\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 77.94\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 239098,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Exam\",\r\n" +
            "          \"weekNumber\": 10,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15082,\r\n" +
            "          \"skillCategory\": \"Performance Testing\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 73.47\r\n" +
            "        },\r\n" +
            "        {\r\n" +
            "          \"assessmentId\": 239099,\r\n" +
            "          \"rawScore\": 100,\r\n" +
            "          \"assessmentTitle\": null,\r\n" +
            "          \"assessmentType\": \"Verbal\",\r\n" +
            "          \"weekNumber\": 10,\r\n" +
            "          \"batchId\": \"2ehKRAAY\",\r\n" +
            "          \"assessmentCategory\": 15082,\r\n" +
            "          \"skillCategory\": \"Performance Testing\",\r\n" +
            "          \"assignmentDate\": null,\r\n" +
            "          \"average\": 76.47\r\n" +
            "        }\r\n" +
            "      ]\r\n" +
            "    }\r\n" +
            "  ]\r\n" +
            "}";
    private static JSONObject obj;

    /**
     * Gets all Batch object from the JSON
     *
     * @return JSONObject of the batchs
     * @throws JSONException if parsing ERORR
     */
    protected static JSONArray getBatchJSONObject() throws JSONException {
        return new JSONObject(json).getJSONArray("batches");
    }

    /**
     * Loads data from JSON object and creates a set of Batchs
     *
     * @return Set<Batch>   batch data
     */
    public static List<Batch> getBatch() {
        assert json != null;
        List<Batch> batchSet = new ArrayList<>();
        try {
            JSONArray batchsJSON = getBatchJSONObject();
            for (int i = 0; i < batchsJSON.length(); i++) {
                JSONObject obj = batchsJSON.getJSONObject(i);
                Batch batch = new Batch(
                        obj.getString("batchId"),
                        obj.getString("name"),
                        obj.getString("startDate"),
                        obj.getString("endDate"),
                        obj.getString("skill"),
                        obj.getString("location"));
                batch.setWeeks(getWeeks(obj));
                batchSet.add(batch);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return batchSet;
    }

    /**
     * Gets week from JSON.
     *
     * @param batch the batch JSONObject
     * @return week weeks in the batch
     */
    protected static List<Week> getWeeks(JSONObject batch) {
        assert json != null;
        List<Week> weeks = new ArrayList<>();
        try {
            getLogger(ParseJSON.class).trace("Getting Week for Batch: " + batch.getString("batchId"));
            // grab the qcNotes object
            JSONArray obj = batch.getJSONArray("qcNotes");
            for (int j = 0; j < obj.length(); j++) {
                // for each week in qcNotes object load data
                //create a new week
                // Week(String weekNumber, String technicalStatus)
                Week week = new Week(
                        obj.getJSONObject(j).getString("week"),
                        obj.getJSONObject(j).getString("technicalStatus")
                );

                week.setBatchId(batch.getString("batchId"));
                getLogger(ParseJSON.class).trace("Week from JSON: " + week);
                // add assessments to the week
                List<Assessment> assessments = getAssessmentByBatch(batch, week);
                getLogger(ParseJSON.class).trace("Adding assessments to the week ... ");
                week.setAssessments(assessments);
                getLogger(ParseJSON.class).trace("Assessments adding to the week ");
                getLogger(ParseJSON.class).trace("Adding categories to the week ... ");
                week.setCategories(getCategoriesByWeek(obj.getJSONObject(j)));
                getLogger(ParseJSON.class).trace("Categories adding to the week ");
                weeks.add(week);
                getLogger(ParseJSON.class).trace("___________________________________");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weeks;
    }

    /**
     * Gets categories by week in JSON.
     *
     * @param week a week from JSONObject
     * @return categories list of categories in a week
     * @throws JSONException the json exception
     */
    protected static List<Category> getCategoriesByWeek(JSONObject week) throws JSONException {
        // grab each categories from qcNotes object
        getLogger(ParseJSON.class).trace("Getting categories for week number:  " + week.getString("week"));
        // grab each categories from qcNotes object
        JSONArray categories = week.getJSONArray("categories");
        List<Category> setCategories = new ArrayList<>();
        for (int k = 0; k < categories.length(); k++) {
            //Category(String name)
            Category category = new Category(categories.getString(k));
            setCategories.add(category);
            getLogger(ParseJSON.class).trace("Adding Category => " + category);
        }
        return setCategories;
    }

    /**
     * Sets assessment by batch from JSON
     *
     * @param batch the batch
     * @param week week object
     * @return assessment by batch
     */
    protected static List<Assessment> getAssessmentByBatch(JSONObject batch, Week week) {
        assert json != null;
        List<Assessment> assessments = new ArrayList<>();

        try {


            JSONArray obj = batch.getJSONArray("assessments");
            for (int i = 0; i < obj.length(); i++) {
            	if(Integer.parseInt(week.getWeekNumber()) == Integer.valueOf(obj.getJSONObject(i).getString("weekNumber")))
            	{
	                Assessment assessment = new Assessment(
	                        Integer.valueOf(obj.getJSONObject(i).getString("rawScore")),
	                        obj.getJSONObject(i).getString("assessmentType"),
	                        Float.valueOf(obj.getJSONObject(i).getString("average"))
	                );
	                assessment.setSkillCategory(new Category(obj.getJSONObject(i).getString("skillCategory")));
	                assessments.add(assessment);
            	}
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    /**
     * Gets assessment from JSON.
     *
     * @return assessment assessment
     */
    protected static List<Assessment> getAssessment() {
        assert json != null;
        List<Assessment> assessments = new ArrayList<>();

        try {
            JSONArray batchsJSON = getBatchJSONObject();
            for (int j = 0; j < batchsJSON.length(); j++) {
                JSONArray obj = batchsJSON.getJSONObject(j).getJSONArray("assessments");
                for (int i = 0; i < obj.length(); i++) {
                    assessments.add(new Assessment(
                            Integer.valueOf(obj.getJSONObject(i).getString("rawScore")),
                            obj.getJSONObject(i).getString("assessmentType"),
                            Float.valueOf(obj.getJSONObject(i).getString("average"))
                    ));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    /**
     * Gets trainer from JSOn.
     *
     * @return trainer trainer
     */
    public static Trainer getTrainer() {
        getLogger(ParseJSON.class).debug("New JSON file set");
        // check if json is null
        assert json != null;

        Trainer trainer = null;
        try {
            obj = new JSONObject(json).getJSONObject("employee");
            getLogger(ParseJSON.class).trace("Trainer object found in JSON");
            trainer = new Trainer(obj.get("firstName").toString(), obj.get("lastName").toString(),
                    obj.get("email").toString());
            getLogger(ParseJSON.class).trace("Trainer object is now created");
        } catch (JSONException e) {
            getLogger(ParseJSON.class).error("Couldn't create Trainer object");
            e.printStackTrace();
        }
        getLogger(ParseJSON.class).debug("Trainer -> " + trainer);
        return trainer;
    }

    /**
     * Read data from file boolean.
     *
     * @param fileName the file name
     * @return boolean boolean
     */
    public static boolean readDataFromFile(String fileName) {

        ClassLoader classLoader = new ParseJSON().getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        getLogger(ParseJSON.class).debug("File Found: " + file.exists());
        try {
            json = new String(Files.readAllBytes(file.toPath()));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Sets json to be parsed.
     *
     * @param json the json
     */
    public static void setJson(String json) {
        getLogger(ParseJSON.class).debug("New JSON file set");
        ParseJSON.json = json;
    }

    /**
     * gets all the batch id from the JSON
     *
     * @return set of batch ids
     */
    public List<String> getBatchIds() {
        getLogger(ParseJSON.class).debug("Calling getBatchIds");
        assert json != null;
        List<String> out = new ArrayList<>();
        JSONArray batchsJSON;
        try {
            batchsJSON = getBatchJSONObject();
            for (int i = 0; i < batchsJSON.length(); i++) {
                out.add(batchsJSON.getJSONObject(i).getString("batchId"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return out;
    }
}

