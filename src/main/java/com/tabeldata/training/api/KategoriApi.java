package com.tabeldata.training.api;

import com.tabeldata.training.entity.Kategori;
import com.tabeldata.training.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kategori")
public class KategoriApi {


    @Autowired
    private KategoriService service;

    @GetMapping("/data")
    public Page<Kategori> pagination(Pageable page) {
        return service.paginate(page);
    }
}
