package org.example.store.models;

import jakarta.persistence.Entity;

@Entity
public class HardDisk extends Product {
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
