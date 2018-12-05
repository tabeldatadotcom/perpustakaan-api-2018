package com.tabeldata.training.service;

import com.tabeldata.training.entity.Kategori;
import com.tabeldata.training.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class KategoriService {

    @Autowired
    private KategoriRepository repository;

    @Transactional
    public Kategori save(Kategori k) {
        return repository.save(k);
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
    }

    public Iterable<Kategori> list() {
        return repository.findAll();
    }

    public Optional<Kategori> findById(String id) {
        return repository.findById(id);
    }

    public Page<Kategori> paginate(Pageable page) {
        return repository.findAll(page);
    }
}
