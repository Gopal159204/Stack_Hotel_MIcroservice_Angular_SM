package com.foodcatlog.micoservice.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private  String itemName;
    private  String itemDescription;
    private  boolean isVeg;
    private  Long price;
    private  Integer restaurantId;
    @Column(nullable = false,columnDefinition = "INT Default 0")
    private Integer quantity;

}
