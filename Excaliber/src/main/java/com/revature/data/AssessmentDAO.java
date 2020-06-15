package com.revature.data;

import com.revature.beans.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Assessment dao.
 */
@Repository
public interface AssessmentDAO extends JpaRepository<Assessment, Integer> {

}
