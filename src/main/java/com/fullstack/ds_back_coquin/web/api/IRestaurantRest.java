package com.fullstack.ds_back_coquin.web.api;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import com.fullstack.ds_back_coquin.dto.request.AddRestaurantDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/restaurant")
public interface IRestaurantRest {


    @PostMapping("/")
    Restaurant ajouterRestaurant(@RequestBody AddRestaurantDto addRestaurantDto);

    @PostMapping("/remplir")
    void ajoutAutomatiqueRestaurants();

    @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable Integer id);

    @GetMapping("/")
    List<Restaurant> getAllRestaurant();

    //@GetMapping("/moyenne/{id}")
    //double getMoyenneNoteRestaurant(@PathVariable Integer id);
}