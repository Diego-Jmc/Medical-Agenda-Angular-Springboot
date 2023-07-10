package com.medical.backend.services;

import com.medical.backend.dtos.PatologyDto;
import com.medical.backend.entities.Patology;

import java.util.List;

public interface IPatologyService {

    List<PatologyDto> findAll();
    PatologyDto findById(Long id);
}
