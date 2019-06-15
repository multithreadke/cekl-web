package com.multi.cekl.service;

import com.multi.cekl.dto.OrderDTO;
import com.multi.cekl.model.Order;
import com.multi.cekl.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Override
    public Order create(OrderDTO order) {
        return repository.save(new Order(productService.getProductById(order.getProduct()), customerService.getCustomerById(order.getCustomer()), order.getQty(), order.getSession(), new Date()));
    }

    @Override
    public Order update(String id, OrderDTO order) {
        Order ord = repository.findByIdIgnoreCase(id);
        ord.setId(id);
        ord.setCustomer(customerService.getCustomerById(order.getCustomer()));
        ord.setDateCreated(new Date());
        ord.setProduct(productService.getProductById(order.getProduct()));
        ord.setQuantity(order.getQty());
        ord.setSessionId(order.getSession());
        return repository.save(ord);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(repository.existsByIdIgnoreCase(id))
        {
            repository.delete(getOrderById(id));
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
    public Order getOrderById(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Order> getOrderList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
