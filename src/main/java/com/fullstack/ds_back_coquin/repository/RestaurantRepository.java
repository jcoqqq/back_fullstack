package com.fullstack.ds_back_coquin.repository;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {


}