package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.TechnicalStatusByWeek;

/**
 * The type Technical status by week service.
 */
@Service
public class TechnicalStatusByWeek_Service {
	public Logger log = Logger.getLogger(TechnicalStatusByWeek_Service.class);
	private final StoreRetrieveService SRSserv;
	
    /**
     * Instantiates a new Technical status by week service.
     *
     * @param s the s
     */
    @Autowired
	public TechnicalStatusByWeek_Service(StoreRetrieveService s) {
		this.SRSserv = s;
	}

    /**
     * Gets table data.
     *
     * @return the table data
     */
    public List<TechnicalStatusByWeek> technicalStatusByWeekTable(int id) {
		Trainer trainer = SRSserv.getTrainerById(id);
		List<TechnicalStatusByWeek> table = new ArrayList<TechnicalStatusByWeek>();
		
		log.info("TechnicalStatusByWeek_Service: "
				+ "Getting table data for TechnicalStatusByWeek");

		//for each batch
		for (Batch b : trainer.getBatches()) {
			
			// for each week of that batch
			for (Week w : b.getWeeks()) {
				
				// get percentage of each technical status
	            int nullSum = 0;
				int poorSum = 0;
	            int averageSum = 0;
	            int goodSum = 0;
	            int superstarSum = 0;
				if (w.getTechnicalStatus() != null) {
					if (w.getTechnicalStatus().contains("null")) {
                        nullSum++;
                    } else if (w.getTechnicalStatus().contains("Poor")) {
                        poorSum++;
                    } else if (w.getTechnicalStatus().contains("Average")) {
                        averageSum++;
                    } else if (w.getTechnicalStatus().contains("Good")) {
                        goodSum++;
                    } else if (w.getTechnicalStatus().contains("Superstar")) {
                        superstarSum++;
                    }
                }
				int totalSum = nullSum + poorSum + averageSum + goodSum + superstarSum; 
				int nullPercent = (nullSum / totalSum) * 100;
				int poorPercent = (poorSum / totalSum) * 100;
				int averagePercent = (averageSum / totalSum) * 100;
				int goodPercent = (goodSum / totalSum) * 100;
				int superstarPercent = (superstarSum / totalSum) * 100;
				
				// get all categories for that week
				ArrayList<String> categories = new ArrayList<String>();
				for (Category c : w.getCategories()) {
					// get category name
					categories.add(c.getName());
				}
				
				// add new TechnicalStatusByWeek(batchName, score, category, weekNumber)
				TechnicalStatusByWeek row = new TechnicalStatusByWeek();
				row.setBatchName(b.getBatchName());
				row.setNullPercent(nullPercent);
				row.setPoorPercent(poorPercent);
				row.setAveragePercent(averagePercent);
				row.setGoodPercent(goodPercent);
				row.setSuperstarPercent(superstarPercent);
				row.setCategories(categories.toArray(new String[categories.size()]));
				row.setWeek(w.getWeekNumber());
				table.add(row);
			}
		}
		
		return table;
    }
}
