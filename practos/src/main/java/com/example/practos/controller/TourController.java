package com.example.practos.controller;


import com.example.practos.models.Tour;
import com.example.practos.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TourController {

    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }


    @GetMapping("/tours")
    public List<Tour> getAllTour() {
        return tourService.getAllTour();
    }

    @PostMapping("/tours")
    public ResponseEntity<Tour> saveTour(@RequestBody Tour tour) {
        Tour newTour = tourService.saveTour(tour);
        return ResponseEntity.ok(newTour);
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        Optional<Tour> tour = tourService.getTourId(id);
        return tour.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/tour/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/tour/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tour) {
        Tour updatedTour = tourService.updateTour(id, tour);
        return ResponseEntity.ok(updatedTour);
    }
}
