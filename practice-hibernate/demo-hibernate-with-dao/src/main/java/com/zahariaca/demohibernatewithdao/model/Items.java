package com.zahariaca.demohibernatewithdao.model;

import javax.persistence.*;

@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Items() {
    }

    public Items(String name) {
        this.name = name;
    }
}
