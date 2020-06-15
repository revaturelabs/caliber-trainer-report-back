package com.revature.data;

import com.revature.beans.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Week dao.
 */
@Repository
public interface WeekDAO extends JpaRepository<Week, Integer> {

}
