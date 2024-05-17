package com.example.practos.controller;


import com.example.practos.models.Country;
import com.example.practos.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public List<Country> getAllCountry() {
        return countryService.getAllCountry();
    }

    @PostMapping("/country")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        Country newCountry = countryService.saveCountry(country);
        return ResponseEntity.ok(newCountry);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Optional<Country> country = countryService.getCountryId(id);
        return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/country/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
        Country updatedCountry = countryService.updateCountry(id, country);
        return ResponseEntity.ok(updatedCountry);
    }
}
