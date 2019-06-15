package com.multi.cekl.service;

import com.multi.cekl.dto.CategoryDTO;
import com.multi.cekl.model.Category;
import com.multi.cekl.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category create(CategoryDTO category) {
        return repository.save(new Category(category.getName(), category.getDescription()));
    }

    @Override
    public Category update(String id, CategoryDTO category) {
        Category cat = repository.findByIdIgnoreCase(id);
        cat.setId(id);
        cat.setName(category.getName());
        cat.setDescription(category.getDescription());
        return repository.save(cat);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(repository.existsByIdIgnoreCase(id))
        {
            repository.delete(getCategoryById(id));
            success = true;
        }else{
            success = false;
        }
        return success;
    }

    @Override
    public Boolean exists(String id) {
        return repository.existsByIdIgnoreCase(id);
    }

    @Override
    public Category getCategoryById(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Category> getCategoryList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
