package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Anggota;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnggotaRepository extends PagingAndSortingRepository<Anggota, String> {
}
