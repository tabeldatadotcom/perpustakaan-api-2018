package com.tabeldata.training.service;

import com.tabeldata.training.entity.Transaksi;
import com.tabeldata.training.entity.TransaksiDetails;
import com.tabeldata.training.repository.BukuRepository;
import com.tabeldata.training.repository.TransaksiDetailRepository;
import com.tabeldata.training.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
