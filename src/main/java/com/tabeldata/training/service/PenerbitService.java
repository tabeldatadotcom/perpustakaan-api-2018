package com.tabeldata.training.service;

import com.tabeldata.training.entity.Penerbit;
import com.tabeldata.training.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class PenerbitService {

    @Autowired
    private PenerbitRepository service;

    @Transactional
    public Penerbit save(Penerbit penerbit) {
        return service.save(penerbit);
    }


    public Iterable<Penerbit> list() {
        return service.findAll();
    }

    @Transactional
    public void delete(String id) {
        service.deleteById(id);
    }

    public Page<Penerbit> findAll(Pageable page) {
        return service.findAll(page);
    }
}
