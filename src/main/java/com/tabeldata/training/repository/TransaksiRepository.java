package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Transaksi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, String> {
}
