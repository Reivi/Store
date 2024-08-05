package org.example.store.services;

import org.example.store.models.HardDisk;
import org.example.store.repositories.HardDiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardDiskService {

    private final HardDiskRepository repository;

    @Autowired
    public HardDiskService(HardDiskRepository repository) {
        this.repository = repository;
    }

    public HardDisk addHardDisk(HardDisk hardDisk) {
        return repository.save(hardDisk);
    }

    public HardDisk updateHardDisk(int id, HardDisk updatedHardDisk) {
        return repository.findById(id)
                .map(HardDisk -> {
                    HardDisk.setSerialNumber(updatedHardDisk.getSerialNumber());
                    HardDisk.setManufacturer(updatedHardDisk.getManufacturer());
                    HardDisk.setPrice(updatedHardDisk.getPrice());
                    HardDisk.setQuantityInStock(updatedHardDisk.getQuantityInStock());
                    HardDisk.setVolume(updatedHardDisk.getVolume());
                    return repository.save(HardDisk);
                })
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public HardDisk getHardDiskById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public List<HardDisk> getAllHardDisks() {
        return repository.findAll();
    }
}