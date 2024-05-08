package com.uipage.restaurant.controller;

import com.uipage.restaurant.Dto.RestaurantDto;
import com.uipage.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    //              @PostMapping("/createRest")
//     public ResponseEntity<RestaurantDto>addrestaurant(@RequestBody RestaurantDto restaurantDto){
//      RestaurantDto addRestaurant=  restaurantService.addRestaurant(restaurantDto);
//      return  new ResponseEntity<>(addRestaurant, HttpStatus.CREATED);
//    }
//    @GetMapping("/fetchAll")
//    public  ResponseEntity<List<RestaurantDto>>fetchAllRest(){
//                  List<RestaurantDto>getAllRest=   restaurantService.getAllRestaurant();
//                  return  new ResponseEntity<>(getAllRest,HttpStatus.OK);
//    }
//    @GetMapping("/get/{id}")
//    public  ResponseEntity<RestaurantDto>getRestaurant(@PathVariable Integer id){
//       return restaurantService.fetchRestaurant(id);
//    }
    @PostMapping("/createRest")
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto createdRestaurant = restaurantService.addRestaurant(restaurantDto);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    // Get all restaurants
    @GetMapping("/fetchAll")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> allRestaurants = restaurantService.getAllRestaurant();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    // Get a specific restaurant by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Integer id) {
        return restaurantService.fetchRestaurant(id);
    }

}
