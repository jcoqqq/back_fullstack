package com.fullstack.ds_back_coquin.service;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import com.fullstack.ds_back_coquin.dto.TagEnum;
import com.fullstack.ds_back_coquin.exception.InvalidValueException;
import com.fullstack.ds_back_coquin.exception.ResourceNotFoundException;
import com.fullstack.ds_back_coquin.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluation with id " + id + " + not found"));
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Restaurant ajouterRestaurant(String nom, String adresse) {
        if (nom == null || adresse == null)
            throw new InvalidValueException("Pas bien, ça doit pas être nul");

        Restaurant restaurant = new Restaurant();
        restaurant.setAdresse(adresse);
        restaurant.setNom(nom);

        restaurantRepository.save(restaurant);

        return restaurant;

    }

    public void ajoutAutomatiqueRestaurant() {

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setNom("La Belle Époque");
        restaurant1.setAdresse("123 Rue de la Gastronomie, Villeville");
        restaurant1.setMoyenneEvaluation(4.7f);
        restaurant1.setUrlImage("belle_epoque.jpg");
        restaurant1.setTag(TagEnum.FASTFOOD);
        restaurantRepository.save(restaurant1);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setNom("Chez Maria");
        restaurant2.setAdresse("456 Avenue des Saveurs, Cuisineland");
        restaurant2.setMoyenneEvaluation(4.2f);
        restaurant2.setUrlImage("chez_maria.jpg");
        restaurant2.setTag(TagEnum.BISTROT);
        restaurantRepository.save(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setNom("Sushizen");
        restaurant3.setAdresse("789 Rue du Sushi, Japanville");
        restaurant3.setMoyenneEvaluation(4.5f);
        restaurant3.setUrlImage("sushizen.jpg");
        restaurant3.setTag(TagEnum.BISTRONOMIQUE);
        restaurantRepository.save(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setNom("Le Bistrot du Coin");
        restaurant4.setAdresse("101 Rue de la Convivialité, Villedétente");
        restaurant4.setMoyenneEvaluation(4.0f);
        restaurant4.setUrlImage("bistrot_du_coin.jpg");
        restaurant4.setTag(TagEnum.BISTROT);
        restaurantRepository.save(restaurant4);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setNom("VégéDélice");
        restaurant5.setAdresse("202 Avenue des Légumes, Veggieville");
        restaurant5.setMoyenneEvaluation(4.8f);
        restaurant5.setUrlImage("vege_delice.jpg");
        restaurant5.setTag(TagEnum.BISTROT);
        restaurantRepository.save(restaurant5);
    }
}