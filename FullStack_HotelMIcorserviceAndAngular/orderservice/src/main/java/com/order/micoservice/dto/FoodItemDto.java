package com.order.micoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FoodItemDto {
    private  int id;
    private  String itemName;
    private  String itemDescription;
    private  boolean isVeg;
    private  Long price;
    private  Integer restaurantId;
    private Integer quantity;
}
