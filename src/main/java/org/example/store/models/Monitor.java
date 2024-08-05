package org.example.store.models;

import jakarta.persistence.Entity;

@Entity
public class Monitor extends Product {
    private double diagonal;

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
