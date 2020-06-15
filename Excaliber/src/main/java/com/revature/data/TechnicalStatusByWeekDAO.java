package com.revature.data;

import com.revature.tables.TechnicalStatusByWeek;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Technical status by week dao.
 */
@Repository
public class TechnicalStatusByWeekDAO {
    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(TechnicalStatusByWeekDAO.class);

    /**
     * Gets table data.
     *
     * @return the table data
     */
    public List<TechnicalStatusByWeek> getTableData() {
        log.info("TechnicalStatusByWeekDAO: "
                + "Getting table data for TechnicalStatusByWeek");
        List<TechnicalStatusByWeek> tableData = null;

        //TODO algorithm for getting data from DB
        //and returning a List of TechnicalStatusByWeek objects

        //for each batch
        // for each week of that batch
        // for each category that week
        // add new TechnicalStatusByWeek(batchId, score, category, weekNumber)

        // start temp sample data
        tableData = new ArrayList<TechnicalStatusByWeek>();
        tableData.add(new TechnicalStatusByWeek("Batch 1", 80.0, "Java Basics", "1"));
        tableData.add(new TechnicalStatusByWeek("Batch 1", 95.5, "OOP", "1"));
        tableData.add(new TechnicalStatusByWeek("Batch 1", 83.5, "Data Complexity", "2"));
        tableData.add(new TechnicalStatusByWeek("Batch 1", 92.0, "Logging", "3"));
        tableData.add(new TechnicalStatusByWeek("Batch 1", 89.0, "Threads", "3"));
        tableData.add(new TechnicalStatusByWeek("Batch 1", 79.5, "Garbage Collection", "3"));

        tableData.add(new TechnicalStatusByWeek("Batch 2", 80.0, "Java Basics", "1"));
        tableData.add(new TechnicalStatusByWeek("Batch 2", 95.5, "OOP", "1"));
        tableData.add(new TechnicalStatusByWeek("Batch 2", 83.5, "Data Complexity", "2"));
        tableData.add(new TechnicalStatusByWeek("Batch 2", 92.0, "Logging", "3"));
        tableData.add(new TechnicalStatusByWeek("Batch 2", 89.0, "Threads", "3"));
        tableData.add(new TechnicalStatusByWeek("Batch 2", 79.5, "Garbage Collection", "3"));

        tableData.add(new TechnicalStatusByWeek("Batch 3", 80.0, "Java Basics", "1"));
        tableData.add(new TechnicalStatusByWeek("Batch 3", 95.5, "OOP", "1"));
        tableData.add(new TechnicalStatusByWeek("Batch 3", 83.5, "Data Complexity", "2"));
        tableData.add(new TechnicalStatusByWeek("Batch 3", 92.0, "Logging", "3"));
        tableData.add(new TechnicalStatusByWeek("Batch 3", 89.0, "Threads", "3"));
        tableData.add(new TechnicalStatusByWeek("Batch 3", 79.5, "Garbage Collection", "3"));
        // end temp sample data

        return tableData;
    }

}
