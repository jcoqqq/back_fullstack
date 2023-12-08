package com.fullstack.ds_back_coquin.repository;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


}