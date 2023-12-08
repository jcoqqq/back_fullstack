package com.fullstack.ds_back_coquin.web.api;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/v1/restaurant")
public interface IRestaurantRest {


    @PostMapping("/{nom}/{adresse}")
    Restaurant ajouterRestaurant(@PathVariable String nom, @PathVariable String adresse);

    @PostMapping("/remplir")
    void ajoutAutomatiqueRestaurants();

    @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable Integer id);

    @GetMapping("/")
    List<Restaurant> getAllRestaurant();

}