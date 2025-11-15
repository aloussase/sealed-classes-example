package io.github.aloussase.sealedclassesdemo.controller;

import io.github.aloussase.sealedclassesdemo.repository.ProductsDatabase;
import io.github.aloussase.sealedclassesdemo.services.ProductPriceCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final ProductsDatabase productsDatabase;
    private final ProductPriceCalculator productPriceCalculator;

    public CartController(ProductsDatabase productsDatabase, ProductPriceCalculator productPriceCalculator) {
        this.productsDatabase = productsDatabase;
        this.productPriceCalculator = productPriceCalculator;
    }

    @GetMapping("/cost")
    public ResponseEntity<BigDecimal> calculateCartPrice() {
        final var products = productsDatabase.findAll();
        final var price = products.stream()
                .map(productPriceCalculator::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(price);
    }

}
