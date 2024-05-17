package com.example.practos.service;

import com.example.practos.models.Tour;
import com.example.practos.repository.CountryRepository;
import com.example.practos.repository.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }


    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public List<Tour> getAllTour() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Long tourId) {
        return tourRepository.findById(tourId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + tourId));
    }

    public Optional<Tour> getTourId(Long tourId) {
        return tourRepository.findById(tourId);
    }

    public Tour updateTour(Long id, Tour updateTour) {
        Optional<Tour> existingPTour = tourRepository.findById(id);
        if (existingPTour.isPresent()) {
            Tour tour = existingPTour.get();
            tour.setDuration_tour(updateTour.getDuration_tour());
            tour.setPrice(updateTour.getPrice());
            tour.setTour_id(updateTour.getTour_id());
            tour.setTour_name(updateTour.getTour_name());
            //tour.setCountry_id(updateTour.getCountry_id());
            //tour.setManager_id(updateTour.getManager_id());
            return tourRepository.save(tour);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }


}
