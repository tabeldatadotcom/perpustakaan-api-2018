package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Kategori;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KategoriRepository extends PagingAndSortingRepository<Kategori, String> {
}
