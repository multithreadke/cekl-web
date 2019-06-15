package com.multi.cekl.repository;

import com.multi.cekl.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, String> {
    Category findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
