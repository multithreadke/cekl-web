package com.multi.cekl.service;


import com.multi.cekl.dto.ProductDTO;
import com.multi.cekl.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product create(ProductDTO product);
    Product update(String id, ProductDTO product);
    Boolean remove(String id);
    Boolean exists(String id);
    Product getProductById(String id);
    Page<Product> getProductList(Pageable pageable);
}
