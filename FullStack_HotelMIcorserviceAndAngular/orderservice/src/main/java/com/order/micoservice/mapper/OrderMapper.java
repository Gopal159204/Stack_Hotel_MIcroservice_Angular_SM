package com.order.micoservice.mapper;

import com.order.micoservice.dto.OrderDto;
import com.order.micoservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);
    Order mapOrderDTOToOrder(OrderDto orderDto);
    OrderDto mapOrderToOrderDTO(Order order);
}
