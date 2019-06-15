package com.multi.cekl.service;


import com.multi.cekl.dto.PackingDTO;
import com.multi.cekl.model.Packing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PackingService {

    Packing create(PackingDTO packing);
    Packing update(String id, PackingDTO packingDTO);
    Boolean remove(String id);
    Boolean exists(String id);
    Packing getPackingById(String id);
    Page<Packing> getPackingList(Pageable pageable);

}
