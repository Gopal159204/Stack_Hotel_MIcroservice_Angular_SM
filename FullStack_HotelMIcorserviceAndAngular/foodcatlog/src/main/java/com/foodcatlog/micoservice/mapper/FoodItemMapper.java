package com.foodcatlog.micoservice.mapper;

import com.foodcatlog.micoservice.dto.FoodItemDto;
import com.foodcatlog.micoservice.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);
    FoodItemDto mapFoodToFoodItemDto(FoodItem foodItem);
}
