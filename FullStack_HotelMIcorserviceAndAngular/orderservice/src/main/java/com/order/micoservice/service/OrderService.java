package com.order.micoservice.service;

import com.order.micoservice.dto.OrderDTOFromFE;
import com.order.micoservice.dto.OrderDto;
import com.order.micoservice.dto.UserDto;
import com.order.micoservice.entity.Order;
import com.order.micoservice.mapper.OrderMapper;
import com.order.micoservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepo  orderRepo;



    public OrderDto saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDto userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDto fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchuser/" + userId, UserDto.class);
    }
}
