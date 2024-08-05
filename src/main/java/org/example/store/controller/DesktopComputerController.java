package org.example.store.controller;

import org.example.store.models.DesktopComputer;
import org.example.store.services.DesktopComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desktops")
public class DesktopComputerController {

    private final DesktopComputerService desktopComputerService;

    @Autowired
    public DesktopComputerController(DesktopComputerService desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @PostMapping
    public DesktopComputer addDesktopComputer(@RequestBody DesktopComputer desktopComputer) {
        return desktopComputerService.addDesktopComputer(desktopComputer);
    }

    @PutMapping("/{id}")
    public DesktopComputer updateDesktopComputer(@PathVariable int id, @RequestBody DesktopComputer desktopComputer) {
        return desktopComputerService.updateDesktopComputer(id, desktopComputer);
    }

    @GetMapping("/{id}")
    public DesktopComputer getDesktopComputerById(@PathVariable int id) {
        return desktopComputerService.getDesktopComputerById(id);
    }

    @GetMapping
    public List<DesktopComputer> getAllDesktopComputers() {
        return desktopComputerService.getAllDesktopComputers();
    }
}
