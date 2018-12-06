package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Buku;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BukuRepository extends PagingAndSortingRepository<Buku, String> {
}
