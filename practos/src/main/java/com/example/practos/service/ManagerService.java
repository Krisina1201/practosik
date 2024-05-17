package com.example.practos.service;

import com.example.practos.models.Manager;
import com.example.practos.models.Tour;
import com.example.practos.repository.ManagerRepository;
import com.example.practos.repository.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + managerId));
    }

    public Optional<Manager> getManagerId(Long managerId) {
        return managerRepository.findById(managerId);
    }

    public Manager updateManager(Long id, Manager updateManager) {
        Optional<Manager> existingManager = managerRepository.findById(id);
        if (existingManager.isPresent()) {
            Manager manager = existingManager.get();
            manager.setManager_id(updateManager.getManager_id());
            manager.setPhone_manager(updateManager.getPhone_manager());
            manager.setLFP_name(updateManager.getLFP_name());
            return managerRepository.save(manager);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteManager(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow();
        managerRepository.delete(manager);
    }
}
