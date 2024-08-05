package org.example.store.services;

import org.example.store.models.Laptop;
import org.example.store.repositories.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private final LaptopRepository repository;

    public LaptopService(LaptopRepository repository) {
        this.repository = repository;
    }

    public Laptop addLaptop(Laptop laptop) {
        return repository.save(laptop);
    }

    public Laptop updateLaptop(int id, Laptop updatedLaptop) {
        return repository.findById(id)
                .map(laptop -> {
                    laptop.setSerialNumber(updatedLaptop.getSerialNumber());
                    laptop.setManufacturer(updatedLaptop.getManufacturer());
                    laptop.setPrice(updatedLaptop.getPrice());
                    laptop.setQuantityInStock(updatedLaptop.getQuantityInStock());
                    laptop.setSize(updatedLaptop.getSize());
                    return repository.save(laptop);
                })
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public Laptop getLaptopById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public List<Laptop> getAllLaptops() {
        return repository.findAll();
    }
}