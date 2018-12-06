create table buku
(
  id              character varying(64)  not null primary key,
  title           character varying(100) not null,
  isbn            character varying(60)  not null unique,
  qty             integer                not null default 0,
  tanggal_publish date                   not null default now(),
  penerbit_id     character varying(64)  not null,
  rak_id          character varying(64)
);

alter table buku
  add constraint fk_penerbit_buku foreign key (penerbit_id)
    references penerbit (id) on update cascade on delete restrict;

alter table buku
  add constraint fk_rak_buku foreign key (rak_id)
    references rak (id) on update cascade on delete restrict;

create table kategori_buku
(
  buku_id     character varying(64) not null,
  kategori_id character varying(64) not null
);

alter table kategori_buku
  add constraint fk_kategori_buku_id foreign key (buku_id)
    references buku (id) on update cascade on delete cascade;

alter table kategori_buku
  add constraint fk_kategori_buku_kategori_id foreign key (kategori_id)
    references kategori (id) on update cascade on delete cascade;

alter table kategori_buku
  add constraint uq_kategori_buku unique (buku_id, kategori_id);