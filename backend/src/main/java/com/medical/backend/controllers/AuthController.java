package com.medical.backend.controllers;


import com.medical.backend.config.UserAuthenticationProvider;
import com.medical.backend.dtos.UserDto;
import com.medical.backend.dtos.UserInputDto;
import com.medical.backend.dtos.UserLoginDto;
import com.medical.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/${vs}")
@RequiredArgsConstructor
public class AuthController {

    private final UserService _userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserLoginDto credentials){
       UserDto user = _userService.login(credentials);
        user.setToken(userAuthenticationProvider.createToken(user));
       return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserInputDto body){
        UserDto user = _userService.register(body);
        user.setToken(userAuthenticationProvider.createToken(user));
        return ResponseEntity.created(URI.create("/users/"+user.getId())).body(user);
    }

    @GetMapping("/test")
    public String sayHello(){
        return "HI";
    }

}
