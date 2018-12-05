package com.tabeldata.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaksiDetails {

    private String id;
    private Transaksi transaksi;
    private Buku buku;
}
