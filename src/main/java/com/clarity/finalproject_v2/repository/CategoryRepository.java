package com.clarity.finalproject_v2.repository;

import com.clarity.finalproject_v2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select * from categories as c where c.name = :categoryName", nativeQuery = true)
    Category findCategory(String categoryName);
}
