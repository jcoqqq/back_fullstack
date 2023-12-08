package com.fullstack.ds_back_coquin.web.controller;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import com.fullstack.ds_back_coquin.dto.request.AddRestaurantDto;
import com.fullstack.ds_back_coquin.service.RestaurantService;
import com.fullstack.ds_back_coquin.web.api.IRestaurantRest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class RestaurantController implements IRestaurantRest {

    private RestaurantService restaurantService;

    @Override
    public Restaurant ajouterRestaurant(AddRestaurantDto addRestaurantDto) {
        log.info("appel de ajouterRestaurant");
        Restaurant restaurant = restaurantService.ajouterRestaurant(addRestaurantDto);
        log.info("retour de ajouterRestaurant");
        return restaurant;
    }

    @Override
    public void ajoutAutomatiqueRestaurants() {
        log.info("appel de ajouterRestaurant");
        restaurantService.ajoutAutomatiqueRestaurant();
        log.info("retour de ajouterRestaurant");
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        log.info("appel de getRestaurantById");
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        log.info("retour de getRestaurantById");
        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        log.info("appel de getAllRestaurant");
        List<Restaurant> restaurants = restaurantService.getAllRestaurant();
        log.info("retour de getAllRestaurant");
        return restaurants;
    }

    /*@Override
    public double getMoyenneNoteRestaurant(Integer id) {
        log.info("appel de getAllRestaurant");
        double moyenne = restaurantService.getMoyenneNoteRestaurant(id);
        log.info("retour de getAllRestaurant");
        return moyenne;
    }*/
}