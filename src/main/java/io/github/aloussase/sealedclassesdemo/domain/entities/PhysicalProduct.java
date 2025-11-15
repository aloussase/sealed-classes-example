package io.github.aloussase.sealedclassesdemo.domain.entities;

import java.math.BigDecimal;

public record PhysicalProduct(
        BigDecimal basePrice,
        BigDecimal shippingCost,
        int quantity
) implements Product {
}
