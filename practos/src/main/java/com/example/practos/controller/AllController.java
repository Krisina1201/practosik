package com.example.practos.controller;

import com.example.practos.models.Tour;
import com.example.practos.service.AllService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AllController {

    private final AllService allService;

    public AllController(AllService allService) {
        this.allService = allService;
    }

    @GetMapping("/{counterId}/tour")
    public ResponseEntity<List<Tour>> getAllTourByCountryId(@PathVariable Long counterId) {
        List<Tour> orders = allService.getAllTourByCountryId(counterId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{managerId}/tour")
    public ResponseEntity<List<Tour>> getAllTourByManagerId(@PathVariable Long managerId) {
        List<Tour> orders = allService.getAllTourByManagerId(managerId);
        return ResponseEntity.ok(orders);
    }
}
