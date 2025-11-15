package io.github.aloussase.sealedclassesdemo.services;

import io.github.aloussase.sealedclassesdemo.domain.entities.DigitalProduct;
import io.github.aloussase.sealedclassesdemo.domain.entities.PhysicalProduct;
import io.github.aloussase.sealedclassesdemo.domain.entities.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductPriceCalculator {
    public BigDecimal calculatePrice(Product product) {
        return switch (product) {
            case DigitalProduct dp -> dp.basePrice()
                    .multiply(BigDecimal.valueOf(dp.quantity()));
            case PhysicalProduct pp -> pp.basePrice()
                    .multiply(BigDecimal.valueOf(pp.quantity()))
                    .add(pp.shippingCost());
        };
    }
}
