package com.multi.cekl.service;

import com.multi.cekl.dto.ProductDTO;
import com.multi.cekl.model.Product;
import com.multi.cekl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PackingService packingService;

    @Override
    public Product create(ProductDTO product) {
        return repository.save(new Product(product.getName(), product.getShortDesc(), product.getLongDesc(), product.getQty(), product.getPrice(), categoryService.getCategoryById(product.getCategory()), packingService.getPackingById(product.getUnit())));
    }

    @Override
    public Product update(String id, ProductDTO product) {
        Product prod = repository.findByIdIgnoreCase(id);
        prod.setId(id);
        prod.setName(product.getName());
        prod.setCategory(categoryService.getCategoryById(product.getCategory()));
        prod.setLongDesc(product.getLongDesc());
        prod.setPacking(packingService.getPackingById(product.getUnit()));
        prod.setPrice(product.getPrice());
        prod.setShortDesc(product.getShortDesc());
        prod.setQty(product.getQty());
        return repository.save(prod);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(exists(id))
        {
            repository.delete(getProductById(id));
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
    public Product getProductById(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Product> getProductList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
