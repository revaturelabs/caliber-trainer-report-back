package com.revature.data;

import com.revature.beans.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekDAO extends JpaRepository<Week, Integer> {

}
