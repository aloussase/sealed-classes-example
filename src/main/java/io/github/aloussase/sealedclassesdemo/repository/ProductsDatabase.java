package io.github.aloussase.sealedclassesdemo.repository;

import io.github.aloussase.sealedclassesdemo.domain.entities.Product;

import java.util.List;

public interface ProductsDatabase {
    List<Product> findAll();
}
