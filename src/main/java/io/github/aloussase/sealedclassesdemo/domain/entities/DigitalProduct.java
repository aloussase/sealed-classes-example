package io.github.aloussase.sealedclassesdemo.domain.entities;

import java.math.BigDecimal;

public record DigitalProduct(
        BigDecimal basePrice,
        int quantity
) implements Product {
}
