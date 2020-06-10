package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Assessment;

@Repository
public interface AssessmentDAO extends JpaRepository<Assessment, Integer> {

}
