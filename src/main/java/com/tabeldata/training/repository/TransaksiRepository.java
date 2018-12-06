package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Transaksi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, String> {

    @Query("update Transaksi set kembali = true, tanggalKembali = ?2 where id = ?1")
    @Modifying
    int pengembalianBuku(String id, Timestamp tanggalKembali);
}
