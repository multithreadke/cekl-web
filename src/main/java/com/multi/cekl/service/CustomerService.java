package com.multi.cekl.service;

import com.multi.cekl.dto.CustomerDTO;
import com.multi.cekl.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Customer create(CustomerDTO customer);
    Customer update(String id, CustomerDTO customer);
    Boolean remove(String id);
    Boolean exists(String id);
    Customer getCustomerById(String id);
    Page<Customer> getCustomerList(Pageable pageable);

}
