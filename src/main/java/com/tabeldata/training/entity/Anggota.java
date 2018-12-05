package com.tabeldata.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anggota")
public class Anggota {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    @Column(name = "nama", nullable = false, length = 100)
    private String nama;
    @Column(name = "nomor_ktp", nullable = false, length = 64)
    private String noKtp;
    @Lob
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "tanggal_lahir")
    private Timestamp tanggalLahir;

}
