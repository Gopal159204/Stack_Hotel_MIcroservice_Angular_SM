package com.uipage.restaurant.service;

import com.uipage.restaurant.Dto.RestaurantDto;
import com.uipage.restaurant.Mapper.RestaurantMapper;
import com.uipage.restaurant.entity.Restaurant;
import com.uipage.restaurant.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto){
        Restaurant savedRestaurant =        restaurantRepo.save(RestaurantMapper.IBSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return  RestaurantMapper.IBSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }
    public List<RestaurantDto> getAllRestaurant(){
        List<Restaurant>restaurantList=restaurantRepo.findAll();
        List<RestaurantDto>restaurantDtoList=restaurantList.stream().map(restaurant -> RestaurantMapper.IBSTANCE.mapRestaurantToRestaurantDto(restaurant)).toList();
        return  restaurantDtoList;
    }
    //    public ResponseEntity< RestaurantDto> fetchRestaurant(Integer id){
//        Optional<Restaurant>optionalRestaurant=restaurantRepo.findById(id);
//        if (optionalRestaurant.isPresent()){
//            return   new ResponseEntity<>(RestaurantMapper.IBSTANCE.mapRestaurantToRestaurantDto(optionalRestaurant.get()), HttpStatus.OK);
//
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//
//
//    }
    public ResponseEntity<RestaurantDto> fetchRestaurant(Integer id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(id);
        if (optionalRestaurant.isPresent()) {
            return new ResponseEntity<>(RestaurantMapper.IBSTANCE.mapRestaurantToRestaurantDto(optionalRestaurant.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }}

