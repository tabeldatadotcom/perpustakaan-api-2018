create table rak
(
  id       varchar(64)  not null primary key,
  nama     varchar(150) not null,
  location int          not null default 0
) engine = InnoDB;

create table kategori
(
  id   varchar(64)  not null primary key,
  nama varchar(100) not null
) engine = InnoDB;

create table penerbit
(
  id     varchar(64)  not null primary key,
  nama   varchar(100) not null,
  alamat varchar(255)
) engine = InnoDB;