package com.medical.backend.services;

import com.medical.backend.dtos.SpecialtyDto;
import com.medical.backend.entities.Specialty;
import com.medical.backend.mappers.SpecialtyMapper;
import com.medical.backend.repositories.SpecialtyRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SpecialtyServiceImp implements ISpecialtyService{


    private final SpecialtyRepository _specialtyRepo;
    private final SpecialtyMapper _mapper;

    @Override
    public List<SpecialtyDto> findAll() {
        return _mapper.specialtyListToSpecialtyDtoList(_specialtyRepo.findAll());
    }

    @Override
    public SpecialtyDto findById(Long id) {
        Optional<Specialty> e = _specialtyRepo.findById(id);

        if(e.isEmpty())
            throw new NoSuchElementException("No se encontro el usuario");

        return _mapper.specialtyToSpecialtyDto(e.get());
    }


}
