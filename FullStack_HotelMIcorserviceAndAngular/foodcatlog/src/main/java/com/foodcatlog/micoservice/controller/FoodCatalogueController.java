package com.foodcatlog.micoservice.controller;

import com.foodcatlog.micoservice.dto.FoodCatlogPage;
import com.foodcatlog.micoservice.dto.FoodItemDto;
import com.foodcatlog.micoservice.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {
    @Autowired
    FoodItemService foodItemService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDTO){
        FoodItemDto foodItemSaved = foodItemService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCatlogPage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCatlogPage foodCataloguePage = foodItemService.fetchFoodCatlogPage(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);


    }
}

