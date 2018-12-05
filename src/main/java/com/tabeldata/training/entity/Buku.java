package com.tabeldata.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buku {

    private String id;
    private String nama;
    private String isbn;
    private Integer stock;
    private Date tanggalPublish;
    private Penerbit penerbit;
    private Rak rak;
    private List<Kategori> daftarKategori = new ArrayList<>();
}
