package com.zahariaca.ecommerce.dao;

import com.zahariaca.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // because it starts with findBy, this is a Query method we will match by categoryId
    // and use the "id" parameter
    // SELECT * FROM product where category_id=?
    // endpoint will be /api/products/search/findByCategoryId?id=1..n
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
