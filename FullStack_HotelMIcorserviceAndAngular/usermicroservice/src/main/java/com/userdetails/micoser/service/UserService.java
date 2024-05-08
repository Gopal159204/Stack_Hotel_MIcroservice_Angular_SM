package com.userdetails.micoser.service;

import com.userdetails.micoser.dto.UserDto;
import com.userdetails.micoser.entity.User;
import com.userdetails.micoser.mapper.UserMapper;
import com.userdetails.micoser.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDto addUser(UserDto  userDto){
       User saveduser=userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
       return  UserMapper.INSTANCE.mapUserToUserFto(saveduser);
    }

    public ResponseEntity<UserDto>fetchUser(Integer userId){
       Optional<User>optinalUSer =userRepo.findById(userId);
       if (optinalUSer.isPresent()){
           return  new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserFto(optinalUSer.get()), HttpStatus.OK);

       }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
