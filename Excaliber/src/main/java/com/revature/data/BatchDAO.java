package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Batch;

public interface BatchDAO extends JpaRepository<Batch, Integer> {

}
