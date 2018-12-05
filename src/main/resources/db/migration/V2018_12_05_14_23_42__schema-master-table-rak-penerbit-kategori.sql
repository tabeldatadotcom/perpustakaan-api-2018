create table rak
(
  id       character varying(64)  not null primary key,
  nama     character varying(150) not null,
  location int                    not null default 0
);

create table kategori
(
  id   character varying(64)  not null primary key,
  nama character varying(100) not null
);

create table penerbit
(
  id     character varying(64)  not null primary key,
  nama   character varying(100) not null,
  alamat character varying(255)
);