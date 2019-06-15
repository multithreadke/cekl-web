package com.multi.cekl.service;

import com.multi.cekl.dto.CustomerDTO;
import com.multi.cekl.model.Customer;
import com.multi.cekl.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer create(CustomerDTO customer) {
        return repository.save(new Customer(customer.getFirstName(), customer.getFirstName(), customer.getGender(), customer.getEmailAddress(), customer.getLastName(), customer.getCountry(), customer.getPhoneNo()));
    }

    @Override
    public Customer update(String id, CustomerDTO customer) {
        Customer cust = getCustomerById(id);
            cust.setId(id);
            cust.setFirstName(customer.getFirstName());
            cust.setMiddleName(customer.getMiddleName());
            cust.setLastName(customer.getLastName());
            cust.setGender(customer.getGender());
            cust.setEmailAddress(customer.getEmailAddress());
            cust.setCountry(customer.getCountry());
            cust.setPhoneNo(customer.getPhoneNo());
        return repository.save(cust);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(exists(id))
        {
            repository.delete(getCustomerById(id));
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
    public Customer getCustomerById(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Customer> getCustomerList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
