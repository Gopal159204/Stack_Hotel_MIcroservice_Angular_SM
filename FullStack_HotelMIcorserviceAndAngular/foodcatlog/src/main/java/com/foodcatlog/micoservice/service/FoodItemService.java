package com.foodcatlog.micoservice.service;

import com.foodcatlog.micoservice.dto.FoodCatlogPage;
import com.foodcatlog.micoservice.dto.FoodItemDto;
import com.foodcatlog.micoservice.dto.Restaurant;
import com.foodcatlog.micoservice.entity.FoodItem;
import com.foodcatlog.micoservice.mapper.FoodItemMapper;
import com.foodcatlog.micoservice.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto){
           FoodItem saved=foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto));
     return  FoodItemMapper.INSTANCE.mapFoodToFoodItemDto(saved);
    }
    public FoodCatlogPage fetchFoodCatlogPage(Integer reasurantId){
        List<FoodItem>listOfFoodItem =foodItemRepo.findByRestaurantId(reasurantId);
        Restaurant restaurant=fetchRestaurantDetailsFromRestaurantMS(reasurantId);
        return  createFoodCatlogPage(listOfFoodItem,restaurant);

    }
    private  FoodCatlogPage createFoodCatlogPage(List<FoodItem> foodItemList, Restaurant restaurant){
        FoodCatlogPage foodCatlogPage=new FoodCatlogPage();
        foodCatlogPage.setFoodItemsList(foodItemList);
        foodCatlogPage.setRestaurant(restaurant);
        return  foodCatlogPage;
    }
    private  Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId){
        return  restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/get/"+restaurantId, Restaurant.class);

    }
    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }

}