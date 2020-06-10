package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Batch;

@Repository
public interface BatchDAO extends JpaRepository<Batch, Integer> {

}
