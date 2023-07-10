package com.medical.backend.services;

import com.medical.backend.dtos.PatientDto;


import java.util.List;

public interface IPatientService {

    List<PatientDto> findAll();

    PatientDto findById(Long id);

    PatientDto deleteById(Long id);

    PatientDto create(PatientDto patient);


}
