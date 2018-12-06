create table transaksi
(
  id              character varying(64)  not null primary key,
  tanggal_pinjam  date                   not null,
  anggota_id      character varying(64)  not null,
  nama_petugas    character varying(100) not null,
  waktu_transaksi timestamp              not null default now(),
  is_return       boolean                not null default false,
  tanggal_kembali timestamp
);

alter table transaksi
  add constraint fk_transaksi_anggota foreign key (anggota_id)
    references anggota (id) on update cascade on delete restrict;

create table transaksi_details
(
  id           character varying(64) not null primary key,
  transaksi_id character varying(64) not null,
  buku_id      character varying(64) not null
);

alter table transaksi_details
  add constraint fk_transaksi_detail_transaksi foreign key (transaksi_id)
    references transaksi (id) on update cascade on delete restrict;

alter table transaksi_details
  add constraint fk_transaksi_detail_buku foreign key (buku_id)
    references buku (id) on update cascade on delete restrict;

alter table transaksi_details
  add constraint un_transkasi_detail unique (buku_id, transaksi_id);