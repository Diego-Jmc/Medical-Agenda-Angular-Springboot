package com.medical.backend.mappers;


import com.medical.backend.dtos.SpecialtyDto;
import com.medical.backend.entities.Specialty;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface SpecialtyMapper {

    SpecialtyDto specialtyToSpecialtyDto(Specialty e);

    List<SpecialtyDto> specialtyListToSpecialtyDtoList(List<Specialty> specialties);
}
