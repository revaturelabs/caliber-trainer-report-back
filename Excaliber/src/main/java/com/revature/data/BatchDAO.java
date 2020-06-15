package com.revature.data;

import com.revature.beans.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Batch dao.
 */
@Repository
public interface BatchDAO extends JpaRepository<Batch, Integer> {

}
