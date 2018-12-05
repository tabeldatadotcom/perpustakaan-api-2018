package com.tabeldata.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kategori")
public class KategoriController {

    @GetMapping("/halo")
    public String halo() {
        return "index";
    }
}
