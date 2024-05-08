package com.order.micoservice.entity;

import com.order.micoservice.dto.FoodItemDto;
import com.order.micoservice.dto.Restaurant;
import com.order.micoservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemsList;
    private Restaurant restaurant;
    private UserDto userDTO;
}
