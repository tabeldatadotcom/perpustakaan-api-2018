create table anggota
(
  id            character varying(64)  not null primary key,
  nama          character varying(100) not null,
  nomor_ktp     character varying(64)  not null unique,
  alamat        text,
  tanggal_lahir timestamp default now()
);