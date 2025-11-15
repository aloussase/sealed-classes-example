package io.github.aloussase.sealedclassesdemo.domain.entities;

public sealed interface Product permits DigitalProduct, PhysicalProduct {
}
