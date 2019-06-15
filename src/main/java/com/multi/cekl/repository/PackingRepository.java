package com.multi.cekl.repository;

import com.multi.cekl.model.Packing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingRepository  extends JpaRepository<Packing, String> {
    Packing findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
