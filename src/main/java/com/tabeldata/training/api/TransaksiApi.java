package com.tabeldata.training.api;

import com.tabeldata.training.entity.Transaksi;
import com.tabeldata.training.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiApi {

    @Autowired
    public TransaksiService service;

    @PostMapping("/peminjaman/buku")
    public ResponseEntity<?> transaksiPeminjamanBuku(@RequestBody Transaksi transaksi) {
        transaksi = service.peminjaman(transaksi);
        return ResponseEntity.ok(transaksi);
    }
}
