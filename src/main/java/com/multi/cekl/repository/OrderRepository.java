package com.multi.cekl.repository;

import com.multi.cekl.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order, String> {
    Order findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
