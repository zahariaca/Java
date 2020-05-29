package com.zahariaca.ecommerce.dao;

import com.zahariaca.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "productCategory" /*json will have this key*/, path="product-category" /*this will be the path to access rest*/)
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
