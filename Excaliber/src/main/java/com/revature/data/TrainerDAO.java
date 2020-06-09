package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Trainer;

public interface TrainerDAO extends JpaRepository<Trainer, Integer> {

}
