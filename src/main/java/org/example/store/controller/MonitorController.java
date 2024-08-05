package org.example.store.controller;

import org.example.store.models.Monitor;
import org.example.store.services.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitors")
public class MonitorController {

    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PostMapping
    public Monitor addMonitor(@RequestBody Monitor monitor) {
        return monitorService.addMonitor(monitor);
    }

    @PutMapping("/{id}")
    public Monitor updateMonitor(@PathVariable int id, @RequestBody Monitor monitor) {
        return monitorService.updateMonitor(id, monitor);
    }

    @GetMapping("/{id}")
    public Monitor getMonitorById(@PathVariable int id) {
        return monitorService.getMonitorById(id);
    }

    @GetMapping
    public List<Monitor> getAllMonitors() {
        return monitorService.getAllMonitors();
    }
}
