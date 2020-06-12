package com.revature.services;

import com.revature.data.TechnicalStatusByWeekDAO;
import com.revature.tables.TechnicalStatusByWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalStatusByWeek_Service {
    TechnicalStatusByWeekDAO dao;

    @Autowired
    public TechnicalStatusByWeek_Service(TechnicalStatusByWeekDAO d) {
        dao = d;
    }

    public List<TechnicalStatusByWeek> getTableData(String batchId) {
        return dao.getTableData(batchId);
    }

}
