package com.order.micoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    private List<FoodItemDto> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;
}
