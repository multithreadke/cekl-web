package com.multi.cekl.repository;

import com.multi.cekl.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, String> {
    Customer findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
