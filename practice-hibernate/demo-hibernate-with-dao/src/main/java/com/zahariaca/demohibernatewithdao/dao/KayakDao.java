package com.zahariaca.demohibernatewithdao.dao;

import com.zahariaca.demohibernatewithdao.model.Kayak;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class KayakDao implements Dao<Kayak> {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Kayak get(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Kayak.class, id);
    }

    @Override
    public List<Kayak> getAll() {
        return null;
    }

    @Override
    @Transactional
    public void save(Kayak kayak) {
        entityManager.unwrap(Session.class).save(kayak);
    }

    @Override
    public void update(Kayak kayak, String[] params) {

    }

    @Override
    public void delete(Kayak kayak) {

    }
}
