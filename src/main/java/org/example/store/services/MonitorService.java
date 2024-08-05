package org.example.store.services;

import org.example.store.models.Monitor;
import org.example.store.repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {

    private final MonitorRepository repository;

    @Autowired
    public MonitorService(MonitorRepository repository) {
        this.repository = repository;
    }

    public Monitor addMonitor(Monitor monitor) {
        return repository.save(monitor);
    }

    public Monitor updateMonitor(int id, Monitor updatedMonitor) {
        return repository.findById(id)
                .map(monitor -> {
                    monitor.setSerialNumber(updatedMonitor.getSerialNumber());
                    monitor.setManufacturer(updatedMonitor.getManufacturer());
                    monitor.setPrice(updatedMonitor.getPrice());
                    monitor.setQuantityInStock(updatedMonitor.getQuantityInStock());
                    monitor.setDiagonal(updatedMonitor.getDiagonal());
                    return repository.save(monitor);
                })
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public Monitor getMonitorById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public List<Monitor> getAllMonitors() {
        return repository.findAll();
    }
}