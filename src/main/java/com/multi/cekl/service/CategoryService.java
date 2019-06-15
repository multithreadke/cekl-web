package com.multi.cekl.service;

import com.multi.cekl.dto.CategoryDTO;
import com.multi.cekl.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Category create(CategoryDTO category);
    Category update(String id, CategoryDTO category);
    Boolean remove(String id);
    Boolean exists(String id);
    Category getCategoryById(String id);
    Page<Category> getCategoryList(Pageable pageable);
}
