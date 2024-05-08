package com.foodcatlog.micoservice.repo;

import com.foodcatlog.micoservice.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
    List<FoodItem>findByRestaurantId(Integer restaurantId);
}
