package com.example.practos.service;

import com.example.practos.models.Country;
import com.example.practos.models.Manager;
import com.example.practos.repository.CountryRepository;
import com.example.practos.repository.ManagerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + countryId));
    }

    public Optional<Country> getCountryId(Long countryId) {
        return countryRepository.findById(countryId);
    }

    public Country updateCountry(Long id, Country updateCountry) {
        Optional<Country> existingCountry = countryRepository.findById(id);
        if (existingCountry.isPresent()) {
            Country country = existingCountry.get();
            country.setCountry_id(updateCountry.getCountry_id());
            country.setCountry_name(updateCountry.getCountry_name());
            country.setVisa(updateCountry.isVisa());
            country.setCurrency_country(updateCountry.getCurrency_country());
            return countryRepository.save(country);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}


