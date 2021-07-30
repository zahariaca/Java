package com.zahariaca.demohibernatewithdao.controller;

import com.zahariaca.demohibernatewithdao.model.Kayak;
import com.zahariaca.demohibernatewithdao.service.KayakService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kayak")
@RequiredArgsConstructor
public class KayakController {
    private final KayakService kayakService;

    @PostMapping("/1")
    public void insertKayak1() {
        Kayak kayak = new Kayak("test", "az", 5, "NDK");
        kayakService.save(kayak);
    }
}
