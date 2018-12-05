package com.tabeldata.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anggota {

    private String id;
    private String nama;
    private String noKtp;
    private String alamat;
    private Date tanggalLahir;

}
