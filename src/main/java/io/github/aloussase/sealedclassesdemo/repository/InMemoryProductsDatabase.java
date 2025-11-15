package io.github.aloussase.sealedclassesdemo.repository;

import io.github.aloussase.sealedclassesdemo.domain.entities.DigitalProduct;
import io.github.aloussase.sealedclassesdemo.domain.entities.PhysicalProduct;
import io.github.aloussase.sealedclassesdemo.domain.entities.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class InMemoryProductsDatabase implements ProductsDatabase {
    @Override
    public List<Product> findAll() {
        return List.of(
                new DigitalProduct(BigDecimal.valueOf(10), 1),
                new PhysicalProduct(
                        BigDecimal.valueOf(10),
                        BigDecimal.valueOf(5),
                        2
                )
        );
    }
}
