package com.medical.backend.mappers;

import com.medical.backend.dtos.PatientDto;
import com.medical.backend.entities.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto toPatientDto(Patient patient);
    List<PatientDto> toPatientDtoList(List<Patient> patientList);

    Patient toPatient(PatientDto patientDto);


}
