package com.multi.cekl.service;

import com.multi.cekl.dto.PackingDTO;
import com.multi.cekl.model.Packing;
import com.multi.cekl.repository.PackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PackingServiceImpl implements PackingService {

    @Autowired
    private PackingRepository repository;

    @Override
    public Packing create(PackingDTO packing) {
        return repository.save(new Packing(packing.getName(), packing.getDescription()));
    }

    @Override
    public Packing update(String id, PackingDTO packing) {
        Packing pack = repository.findByIdIgnoreCase(id);
        pack.setId(id);
        pack.setName(packing.getName());
        pack.setDescription(packing.getDescription());
        return repository.save(pack);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(exists(id))
        {
            repository.delete(getPackingById(id));
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
    public Packing getPackingById(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Packing> getPackingList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
