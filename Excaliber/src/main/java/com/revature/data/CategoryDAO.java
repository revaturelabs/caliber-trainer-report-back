package com.revature.data;

import com.revature.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>  {
    Category findCategoryByName(String name);

}
