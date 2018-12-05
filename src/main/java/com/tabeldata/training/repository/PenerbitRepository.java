package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Penerbit;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PenerbitRepository extends PagingAndSortingRepository<Penerbit, String> {
}
