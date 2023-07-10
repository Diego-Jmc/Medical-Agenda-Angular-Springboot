package com.medical.backend.services;

import com.medical.backend.dtos.UserDto;
import com.medical.backend.dtos.UserInputDto;
import com.medical.backend.dtos.UserLoginDto;
import com.medical.backend.entities.User;
import com.medical.backend.exceptions.AppException;
import com.medical.backend.mappers.UserMapper;
import com.medical.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;
    private final UserMapper _mapper;


    public UserDto login(UserLoginDto credentialsDto) {
        User user = _userRepository.findByEmail(credentialsDto.getEmail())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (_passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return _mapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }


    public UserDto register(UserInputDto userDto) {
        Optional<User> optionalUser = _userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = _mapper.userInputToToUser(userDto);
        user.setPassword(_passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = _userRepository.save(user);

        return _mapper.toUserDto(savedUser);
    }



    public UserDto findByEmail(String email) {
        User user =_userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return _mapper.toUserDto(user);
    }


    public List<UserDto> findAll(){
        return _mapper.userListToUserDtoList(_userRepository.findAll());
    }


    public UserDto findById(Long id){
        User user =_userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return _mapper.toUserDto(user);

    }

    public UserDto deleteById(Long id){
        User user =_userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        _userRepository.deleteById(id);
        return _mapper.toUserDto(user);
    }




}
