package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>  {

}
