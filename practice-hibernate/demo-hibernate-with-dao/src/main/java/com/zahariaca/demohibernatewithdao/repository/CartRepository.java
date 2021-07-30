package com.zahariaca.demohibernatewithdao.repository;

import com.zahariaca.demohibernatewithdao.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
