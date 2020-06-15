package com.revature.data;

import com.revature.tables.BatchTechnicalStatusBySkillCategory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Batch technical status by skill category dao.
 */

@Repository
public class BatchTechnicalStatusBySkillCategoryDAO {
    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(BatchTechnicalStatusBySkillCategoryDAO.class);

    /**
     * Get table data list.
     *
     * @return the list
     */
    public List<BatchTechnicalStatusBySkillCategory> getTableData() {

        //TODO table data logic here

        return null;
    }
}
