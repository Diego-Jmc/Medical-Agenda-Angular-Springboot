package com.medical.backend.controllers;


import com.medical.backend.dtos.PatologyDto;
import com.medical.backend.services.IPatologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/${url.patologies}")
public class PatologyController {

    private final IPatologyService _patologyService;

    @GetMapping
    public List<PatologyDto> findAll(){
            return _patologyService.findAll();

    }

    @GetMapping("{id}")
    public PatologyDto findById(@PathVariable Long id){
        try{
            return _patologyService.findById(id);
        }catch (Exception e){
            throw new NoSuchElementException("register not found");
        }
    }


}
