package com.tabeldata.training.repository;

import com.tabeldata.training.entity.Buku;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BukuRepository extends PagingAndSortingRepository<Buku, String> {

    @Modifying
    @Query("update from Buku set stock = stock - ?2 where id = ?1")
    int updateStockPeminjaman(String id, Integer stok);

    @Query("update from Buku set stock = stock + ?2 where id = ?1")
    @Modifying
    int updateStockPengembalian(String id, Integer stok);
}
