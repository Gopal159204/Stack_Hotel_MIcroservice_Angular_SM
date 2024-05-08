package com.uipage.restaurant.Mapper;

import com.uipage.restaurant.Dto.RestaurantDto;
import com.uipage.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper IBSTANCE= Mappers.getMapper(RestaurantMapper.class);
    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
