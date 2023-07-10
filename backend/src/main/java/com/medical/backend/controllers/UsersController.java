package com.medical.backend.controllers;


import com.medical.backend.dtos.UserDto;
import com.medical.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/${url.users}")
public class UsersController {


    private final UserService _userService;

    @GetMapping
    public List<UserDto> findAll(){
        return _userService.findAll();
    }


    @GetMapping("{id}")
    public UserDto findById(@PathVariable Long id){
        try{
            return _userService.findById(id);

        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }

    }

    @DeleteMapping("{id}")

    public UserDto deleteById(@PathVariable Long id){
        try{
            return _userService.deleteById(id);

        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
}
