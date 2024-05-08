package com.uipage.restaurant.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RestaurantDto {
    private int id;

    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
