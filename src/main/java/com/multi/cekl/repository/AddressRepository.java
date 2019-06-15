package com.multi.cekl.repository;

import com.multi.cekl.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
    Address findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
