package com.userdetails.micoser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {
    private  int userId;
    private String username;
    private  String password;
    private  String address;
    private  String city;
}
