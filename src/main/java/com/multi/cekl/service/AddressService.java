package com.multi.cekl.service;

import com.multi.cekl.dto.AddressDTO;
import com.multi.cekl.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {

    Address create(AddressDTO address);
    Address update(String id, AddressDTO address);
    Boolean remove(String id);
    Boolean exists(String id);
    Address getAddressById(String id);
    Page<Address> getAddressList(Pageable pageable);

}
