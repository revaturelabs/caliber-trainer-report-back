package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Trainer;

@Repository
public interface TrainerDAO extends JpaRepository<Trainer, Integer> {

}
