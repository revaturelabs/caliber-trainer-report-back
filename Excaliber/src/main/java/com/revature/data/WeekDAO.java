package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Week;

public interface WeekDAO extends JpaRepository<Week, Integer> {

}
