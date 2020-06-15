package com.revature.services;

import com.revature.data.TechnicalStatusByWeekDAO;
import com.revature.tables.TechnicalStatusByWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Technical status by week service.
 */
@Service
public class TechnicalStatusByWeek_Service {
    /**
     * The Dao.
     */
    TechnicalStatusByWeekDAO dao;

    /**
     * Instantiates a new Technical status by week service.
     *
     * @param d the d
     */
    @Autowired
    public TechnicalStatusByWeek_Service(TechnicalStatusByWeekDAO d) {
        dao = d;
    }

    /**
     * Gets table data.
     *
     * @return the table data
     */
    public List<TechnicalStatusByWeek> getTableData() {
        return dao.getTableData();
    }

}
