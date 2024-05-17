package com.example.practos.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long country_id;

    @Column(nullable = false)
    private String country_name;

    @Column(nullable = false)
    private boolean visa;

    @Column(nullable = false)
    private String currency_country;

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Tour> tours;

    public List<Tour> getTour() {
        return tours;
    }

    public void setTour(List<Tour> tour) {
        this.tours = tour;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public String getCountry_name() {
        return country_name;
    }


    public boolean isVisa() {
        return visa;
    }

    public String getCurrency_country() {
        return currency_country;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setVisa(boolean visa) {
        this.visa = visa;
    }

    public void setCurrency_country(String currency_country) {
        this.currency_country = currency_country;
    }
}
