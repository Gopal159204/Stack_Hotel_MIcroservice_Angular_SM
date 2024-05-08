package com.userdetails.micoser.mapper;

import com.userdetails.micoser.dto.UserDto;
import com.userdetails.micoser.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    User mapUserDtoToUser(UserDto userDto);
    UserDto mapUserToUserFto(User user);


}
