package com.order.micoservice.repo;

import com.order.micoservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order,Integer> {
}
