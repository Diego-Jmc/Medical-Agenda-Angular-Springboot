package com.medical.backend.mappers;

import com.medical.backend.dtos.PatologyDto;
import com.medical.backend.entities.Patology;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatologyMapper {
    PatologyDto toPatologyDto(Patology patology);
    List<PatologyDto> toPatologyDtoList(List<Patology> patologyList);

}
