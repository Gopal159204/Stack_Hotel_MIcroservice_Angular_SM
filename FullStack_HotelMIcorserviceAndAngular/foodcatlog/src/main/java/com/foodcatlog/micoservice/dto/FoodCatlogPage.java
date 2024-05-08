package com.foodcatlog.micoservice.dto;

import com.foodcatlog.micoservice.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FoodCatlogPage {

    private List<FoodItem> foodItemsList;
    private  Restaurant restaurant;

}