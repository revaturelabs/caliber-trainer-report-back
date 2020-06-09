package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Assessment;

public interface AssessmentDAO extends JpaRepository<Assessment, Integer> {

}
