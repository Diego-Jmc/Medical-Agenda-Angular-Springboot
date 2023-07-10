package com.medical.backend.services;

import com.medical.backend.dtos.PatologyDto;
import com.medical.backend.entities.Patology;
import com.medical.backend.mappers.PatologyMapper;
import com.medical.backend.repositories.PatologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatologyServicesImp implements IPatologyService{

    private final PatologyRepository _patologyRepo;
    private final PatologyMapper _mapper;

    @Override
    public List<PatologyDto> findAll() {
        return _mapper.toPatologyDtoList(_patologyRepo.findAll());
    }

    @Override
    public PatologyDto findById(Long id) {

        Patology patology = _patologyRepo.findById(id).orElseThrow(NoSuchElementException::new);
        return _mapper.toPatologyDto(patology);

    }
}
