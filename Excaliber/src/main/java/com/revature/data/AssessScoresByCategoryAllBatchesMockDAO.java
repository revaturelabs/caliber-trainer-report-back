package com.revature.data;

import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assess scores by category all batches mock dao.
 */
@Repository
public class AssessScoresByCategoryAllBatchesMockDAO {

    /**
     * Gets mock data.
     *
     * @return the mock data
     */
    public AssessScoresByCategoryAllBatches getMockData() {
        List<Double> aScores = new ArrayList<Double>(); //assessment scores for each week
        List<String> batchNames = new ArrayList<String>(); //corresponding batch names
        List<String> batchId = new ArrayList<String>();
        AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();

        aScores.add(71.23);
        aScores.add(81.34);
        aScores.add(70.35);

        batchNames.add("1804  Apr16 -2");
        batchId.add("Ix2x2UAB");

        batchNames.add("1903 Mar04 Full Stack Java/JEE");
        batchId.add("2rgIVAAY");

        batchNames.add("1909 Sep30 Other");
        batchId.add("2ehKRAAY");

        catAll = new AssessScoresByCategoryAllBatches(aScores, batchNames, batchId, "Verbal");

        return catAll;
    }
}
