package com.example.practos.service;

import com.example.practos.models.Country;
import com.example.practos.models.Manager;
import com.example.practos.models.Tour;
import com.example.practos.repository.CountryRepository;
import com.example.practos.repository.ManagerRepository;
import com.example.practos.repository.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AllService {

    public final CountryRepository countryRepository;
    public final ManagerRepository managerRepository;
    public final TourRepository tourRepository;

    @Autowired
    public AllService(CountryRepository countryRepository, ManagerRepository managerRepository, TourRepository tourRepository) {
        this.countryRepository = countryRepository;
        this.managerRepository = managerRepository;
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTourByCountryId(Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id" + countryId));
        return country.getTour();
    }

    public List<Tour> getAllTourByManagerId(Long managerId) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id" + managerId));
        return manager.getTours();
    }
}
