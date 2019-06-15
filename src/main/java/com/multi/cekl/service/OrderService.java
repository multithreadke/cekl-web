package com.multi.cekl.service;


import com.multi.cekl.dto.OrderDTO;
import com.multi.cekl.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Order create(OrderDTO order);
    Order update(String id, OrderDTO order);
    Boolean remove(String id);
    Boolean exists(String id);
    Order getOrderById(String id);
    Page<Order> getOrderList(Pageable pageable);
}
