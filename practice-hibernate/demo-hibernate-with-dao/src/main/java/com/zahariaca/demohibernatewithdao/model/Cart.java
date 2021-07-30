package com.zahariaca.demohibernatewithdao.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<Items> items;

    public Cart() {
    }

    public Cart(Set<Items> items) {
        this.items = items;
    }
}
