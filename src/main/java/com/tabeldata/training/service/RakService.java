package com.tabeldata.training.service;

import com.tabeldata.training.entity.Rak;
import com.tabeldata.training.repository.RakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RakService {

    @Autowired
    public RakRepository repository;

    public Iterable<Rak> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Rak save(Rak value) {
        return repository.save(value);
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
    }

    public Page<Rak> findAll(Pageable page) {
        return repository.findAll(page);
    }
}
