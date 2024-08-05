package org.example.store.services;

import org.example.store.models.DesktopComputer;
import org.example.store.repositories.DesktopComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesktopComputerService {

    private final DesktopComputerRepository repository;

    @Autowired
    public DesktopComputerService(DesktopComputerRepository repository) {
        this.repository = repository;
    }

    public DesktopComputer addDesktopComputer(DesktopComputer desktopComputer) {
        return repository.save(desktopComputer);
    }

    public DesktopComputer updateDesktopComputer(int id, DesktopComputer updatedDesktopComputer) {
        return repository.findById(id)
                .map(desktopComputer -> {
                    desktopComputer.setSerialNumber(updatedDesktopComputer.getSerialNumber());
                    desktopComputer.setManufacturer(updatedDesktopComputer.getManufacturer());
                    desktopComputer.setPrice(updatedDesktopComputer.getPrice());
                    desktopComputer.setQuantityInStock(updatedDesktopComputer.getQuantityInStock());
                    desktopComputer.setFormFactor(updatedDesktopComputer.getFormFactor());
                    return repository.save(desktopComputer);
                })
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public DesktopComputer getDesktopComputerById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найден продукт с таким id: " + id));
    }

    public List<DesktopComputer> getAllDesktopComputers() {
        return repository.findAll();
    }
}

