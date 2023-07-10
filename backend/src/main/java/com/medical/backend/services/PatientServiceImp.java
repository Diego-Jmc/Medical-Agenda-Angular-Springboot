package com.medical.backend.services;

import com.medical.backend.dtos.PatientDto;
import com.medical.backend.entities.Patient;
import com.medical.backend.exceptions.AppException;
import com.medical.backend.mappers.PatientMapper;
import com.medical.backend.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImp implements IPatientService{


    private final PatientRepository _patientRepo;
    private final PatientMapper _mapper;

    @Override
    public List<PatientDto> findAll() {

        return _mapper.toPatientDtoList(_patientRepo.findAll());

    }

    @Override
    public PatientDto findById(Long id) {
        Patient p = _patientRepo.findById(id).orElseThrow(NoSuchElementException::new);
        return _mapper.toPatientDto(p);

    }

    @Override
    public PatientDto deleteById(Long id) {
        Patient p = _patientRepo.findById(id).orElseThrow(NoSuchElementException::new);
        _patientRepo.deleteById(id);
        return _mapper.toPatientDto(p);

    }

    @Override
    public PatientDto create(PatientDto patient) {

        Optional<Patient> entity = _patientRepo.findByDocumentId(patient.getDocumentId());

        if(entity.isPresent())
            throw new AppException("Patient already exists!", HttpStatus.BAD_REQUEST);

        _patientRepo.save(_mapper.toPatient(patient));

        return patient;
    }
}
