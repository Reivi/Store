package org.example.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Laptop extends Product {
    public enum Size {
        SIZE_13,
        SIZE_14,
        SIZE_15,
        SIZE_17
    }

    @Enumerated(EnumType.STRING)
    private Size size;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
