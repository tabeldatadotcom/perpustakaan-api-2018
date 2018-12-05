package com.tabeldata.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaksi {

    private String id;
    private Date tanggal;
    private Anggota anggota;
    private String petugas;
    private Timestamp createdDate;
    private boolean kembali;
}
