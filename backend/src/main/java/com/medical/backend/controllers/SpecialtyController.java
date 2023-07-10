package com.medical.backend.controllers;


import com.medical.backend.dtos.SpecialtyDto;
import com.medical.backend.services.ISpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/${url.specialties}")
public class SpecialtyController {

    private final ISpecialtyService _specialtiesService;


    @GetMapping
    public List<SpecialtyDto> findAll(){
        return _specialtiesService.findAll();
    }

    @GetMapping("{id}")
    public SpecialtyDto findById(@PathVariable Long id){
        try{
            return _specialtiesService.findById(id);
        }catch (Exception e){
            throw new NoSuchElementException("No se encontró");
        }
    }



}
