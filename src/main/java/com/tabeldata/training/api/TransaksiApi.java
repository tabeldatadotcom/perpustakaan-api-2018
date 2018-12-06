package com.tabeldata.training.api;

import com.tabeldata.training.entity.Transaksi;
import com.tabeldata.training.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiApi {

    @Autowired
    public TransaksiService service;

    @GetMapping("/list")
    public Iterable<Transaksi> findAll() {
        return service.findAll();
    }

    @GetMapping("/page")
    public Page<Transaksi> findAll(Pageable page) {
        return service.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaksi> findById(@PathVariable("id") String id) {
        Optional<Transaksi> transaksiOptional = service.findById(id);
        if (transaksiOptional.isPresent()) return ResponseEntity.ok(transaksiOptional.get());
        else return ResponseEntity.noContent().build();
    }

    @PostMapping("/peminjaman/buku")
    public ResponseEntity<?> transaksiPeminjamanBuku(@RequestBody Transaksi transaksi) {
        transaksi = service.peminjaman(transaksi);
        return ResponseEntity.ok(transaksi);
    }

    @PostMapping("/pengembalian/buku")
    public ResponseEntity<?> transaksiPengembalianBuku(@RequestParam("id") String transaksiId) {
        Optional<Transaksi> transaksiOptional = service.findById(transaksiId);
        if (!transaksiOptional.isPresent()) return ResponseEntity.noContent().build();
        else {
            Transaksi transaksi = transaksiOptional.get();
            if (transaksi.isKembali()) return ResponseEntity.badRequest().body("Telah dikembalikan!");
            else {
                transaksi = service.pengembalian(transaksi);
                return ResponseEntity.ok(transaksi);
            }
        }

    }
}
