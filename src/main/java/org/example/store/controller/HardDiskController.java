package org.example.store.controller;

import org.example.store.models.HardDisk;
import org.example.store.services.HardDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harddisks")
public class HardDiskController {

    private final HardDiskService hardDiskService;

    @Autowired
    public HardDiskController(HardDiskService hardDiskService) {
        this.hardDiskService = hardDiskService;
    }

    @PostMapping
    public HardDisk addHardDisk(@RequestBody HardDisk hardDisk) {
        return hardDiskService.addHardDisk(hardDisk);
    }

    @PutMapping("/{id}")
    public HardDisk updateHardDisk(@PathVariable int id, @RequestBody HardDisk hardDisk) {
        return hardDiskService.updateHardDisk(id, hardDisk);
    }

    @GetMapping("/{id}")
    public HardDisk getHardDiskById(@PathVariable int id) {
        return hardDiskService.getHardDiskById(id);
    }

    @GetMapping
    public List<HardDisk> getAllHardDisks() {
        return hardDiskService.getAllHardDisks();
    }
}
