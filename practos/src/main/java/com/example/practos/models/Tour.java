package com.example.practos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tour_id;

    @Column(nullable = false)
    private String tour_name;

    @Column(nullable = false)
    private String duration_tour;

    @Column(nullable = false)
    private int price;

//    @Column(nullable = false)
//    private Long country_id;

//    @Column(nullable = false)
//    private Long manager_id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonIgnore
    private Manager manager;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Long getTour_id() {
        return tour_id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public String getDuration_tour() {
        return duration_tour;
    }

    public int getPrice() {
        return price;
    }

//    public Long getCountry_id() {
//        return country_id;
//    }

//    public Long getManager_id() {
//        return manager_id;
//    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public void setDuration_tour(String duration_tour) {
        this.duration_tour = duration_tour;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public void setCountry_id(Long country_id) {
//        this.country_id = country_id;
//    }

//    public void setManager_id(Long manager_id) {
//        this.manager_id = manager_id;
//    }
}
