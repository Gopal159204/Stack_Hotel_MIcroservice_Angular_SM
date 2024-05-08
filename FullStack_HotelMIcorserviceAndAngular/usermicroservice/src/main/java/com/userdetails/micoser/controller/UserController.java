package com.userdetails.micoser.controller;

import com.userdetails.micoser.dto.UserDto;
import com.userdetails.micoser.entity.User;
import com.userdetails.micoser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserDto>addUser(@RequestBody UserDto userDto){
        UserDto savedUser =userService.addUser(userDto);
        return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/fetchuser/{userId}")
    public ResponseEntity<UserDto>fetchUser(@PathVariable Integer userId){
     return userService.fetchUser(userId);
    }
}
