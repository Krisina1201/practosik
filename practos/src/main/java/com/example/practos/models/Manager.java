package com.example.practos.models;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
    @Table(name = "manager")
    public class Manager {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long manager_id;

        @Column(nullable = false)
        private String LFP_name;

        @Column(nullable = false)
        private String phone_manager;

//    @OneToMany(mappedBy = "manager")
//    private List<Tour> tour;

        @OneToMany(mappedBy = "manager", cascade = CascadeType.REMOVE, orphanRemoval = true)
        private List<Tour> tours;

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public String getPhone_manager() {
        return phone_manager;
    }

    public void setPhone_manager(String phone_manager) {
        this.phone_manager = phone_manager;
    }

    public String getLFP_name() {
        return LFP_name;
    }



    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public void setLFP_name(String LFP_name) {
        this.LFP_name = LFP_name;
    }
}
