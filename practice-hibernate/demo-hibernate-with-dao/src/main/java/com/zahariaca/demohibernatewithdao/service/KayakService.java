package com.zahariaca.demohibernatewithdao.service;

import com.zahariaca.demohibernatewithdao.dao.KayakDao;
import com.zahariaca.demohibernatewithdao.model.Kayak;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class KayakService {
    private final KayakDao kayakDao;

    @Transactional
    public void save(Kayak kayak) {
        kayakDao.save(kayak);
    }
}
