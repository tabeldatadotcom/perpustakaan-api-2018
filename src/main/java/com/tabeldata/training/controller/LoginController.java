package com.tabeldata.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/proses-login")
    public String redirectLogin() {
        return "redirect:/";
    }
}
