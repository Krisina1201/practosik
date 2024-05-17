package com.example.practos.controller;


import com.example.practos.models.Manager;
import com.example.practos.models.Tour;
import com.example.practos.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerService.getAllManager();
    }

    @PostMapping("/managers")
    public ResponseEntity<Manager> saveManager(@RequestBody Manager manager) {
        Manager newManager = managerService.saveManager(manager);
        return ResponseEntity.ok(newManager);
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        Optional<Manager> manager = managerService.getManagerId(id);
        return manager.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/manager/{id}")
    public ResponseEntity<String> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/manager/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager manager) {
        Manager updatedManager = managerService.updateManager(id, manager);
        return ResponseEntity.ok(updatedManager);
    }
}
