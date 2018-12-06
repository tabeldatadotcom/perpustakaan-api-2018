package com.tabeldata.training.service;

import com.tabeldata.training.entity.Transaksi;
import com.tabeldata.training.entity.TransaksiDetails;
import com.tabeldata.training.repository.BukuRepository;
import com.tabeldata.training.repository.TransaksiDetailRepository;
import com.tabeldata.training.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TransaksiService {

    @Autowired
    private BukuRepository bukuRepository;
    @Autowired
    private TransaksiRepository transaksiRepository;
    @Autowired
    private TransaksiDetailRepository detailTransaksiRepository;

    public Iterable<Transaksi> findAll() {
        return transaksiRepository.findAll();
    }

    public Optional<Transaksi> findById(String id){
        return transaksiRepository.findById(id);
    }

    public Page<Transaksi> findAll(Pageable page){
        return transaksiRepository.findAll(page);
    }

    @Transactional
    public Transaksi peminjaman(Transaksi transaksi) {
        List<TransaksiDetails> details = transaksi.getDetails();
        transaksi = transaksiRepository.save(transaksi);
        for (TransaksiDetails detail : details) {
            detail.setTransaksi(transaksi);
            detailTransaksiRepository.save(detail);
            bukuRepository.updateStockPeminjaman(detail.getBuku().getId(), 1);
        }
        return transaksi;
    }

    @Transactional
    public Transaksi pengembalian(Transaksi transaksi) {
        transaksiRepository.pengembalianBuku(transaksi.getId(), Timestamp.valueOf(LocalDateTime.now()));
        for (TransaksiDetails detail : transaksi.getDetails()) {
            bukuRepository.updateStockPengembalian(detail.getBuku().getId(), 1);
        }
        return transaksi;
    }

}
