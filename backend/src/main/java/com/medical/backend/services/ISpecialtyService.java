package com.medical.backend.services;

import com.medical.backend.dtos.SpecialtyDto;

import java.util.List;

public interface ISpecialtyService {

    List<SpecialtyDto> findAll();

    SpecialtyDto findById(Long id);
}
