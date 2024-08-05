package org.example.store.controller;

import org.example.store.models.Laptop;
import org.example.store.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return laptopService.addLaptop(laptop);
    }

    @PutMapping("/{id}")
    public Laptop updateLaptop(@PathVariable int id, @RequestBody Laptop laptop) {
        return laptopService.updateLaptop(id, laptop);
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable int id) {
        return laptopService.getLaptopById(id);
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }
}
