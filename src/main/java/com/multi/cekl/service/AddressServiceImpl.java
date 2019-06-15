package com.multi.cekl.service;

import com.multi.cekl.dto.AddressDTO;
import com.multi.cekl.model.Address;
import com.multi.cekl.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private CustomerService customerService;

    @Override
    public Address create(AddressDTO address) {
        return repository.save(new Address(address.getStreetAddress(), address.getCity(), address.getState(), address.getZipCode(), customerService.getCustomerById(address.getCustomer())));
    }

    @Override
    public Address update(String id, AddressDTO address) {
        Address addr = repository.findByIdIgnoreCase(id);
        addr.setId(id);
        addr.setCity(address.getCity());
        addr.setCustomer(customerService.getCustomerById(address.getCustomer()));
        addr.setState(address.getState());
        addr.setStreetAddress(address.getStreetAddress());
        addr.setZipCode(address.getZipCode());
        return repository.save(addr);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(repository.existsByIdIgnoreCase(id))
        {
            repository.delete(getAddressById(id));
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
    public Address getAddressById(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Address> getAddressList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}