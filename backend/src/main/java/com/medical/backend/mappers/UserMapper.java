package com.medical.backend.mappers;


import com.medical.backend.dtos.UserDto;
import com.medical.backend.dtos.UserInputDto;
import com.medical.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User userInputToToUser(UserInputDto userDto);

}
