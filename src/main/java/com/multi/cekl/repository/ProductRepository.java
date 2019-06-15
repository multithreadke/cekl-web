package com.multi.cekl.repository;

import com.multi.cekl.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, String> {
    Product findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
