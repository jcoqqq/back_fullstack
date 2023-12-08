package service;

import com.fullstack.ds_back_coquin.domain.Restaurant;
import com.fullstack.ds_back_coquin.dto.request.AddRestaurantDto;
import com.fullstack.ds_back_coquin.exception.InvalidValueException;
import com.fullstack.ds_back_coquin.repository.RestaurantRepository;
import com.fullstack.ds_back_coquin.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class RestaurantServiceTest {

    RestaurantService restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);

        restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    void shouldReturnRestaurant() {

        Restaurant restaurant = new Restaurant();
        restaurant.setNom("non");
        restaurant.setAdresse("adresse");

        when(restaurantRepository.findById(3)).thenReturn(Optional.of(restaurant));

        Restaurant restaurant1 = restaurantService.getRestaurantById(3);

        assertThat(restaurant1).isEqualTo(restaurant);
    }

    @Test
    void shouldAjouterRestaurant() {

        AddRestaurantDto addRestaurantDto = new AddRestaurantDto();
        addRestaurantDto.setNom("nom");



        InvalidValueException exception = assertThrows(InvalidValueException.class, () ->
                restaurantService.ajouterRestaurant(addRestaurantDto));

        assertThat(exception.getMessage()).contains("Pas bien,");

        addRestaurantDto.setAdresse("ad");

        Restaurant restaurant = new Restaurant();
        restaurant.setAdresse(addRestaurantDto.getAdresse());
        restaurant.setNom(addRestaurantDto.getNom());

        restaurantService.ajouterRestaurant(addRestaurantDto);

        verify(restaurantRepository, times(1))
                .save(restaurant);
    }
}