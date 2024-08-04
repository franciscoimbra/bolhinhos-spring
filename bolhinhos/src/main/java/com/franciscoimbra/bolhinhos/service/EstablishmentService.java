package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.mapper.EstablishmentMapper;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Autowired
    private EstablishmentMapper establishmentMapper;

    public EstablishmentDTO create(EstablishmentDTO establishmentDTO) {
        return establishmentMapper.toDTO(establishmentRepository.save(establishmentMapper.toEntity(establishmentDTO)));
    }

    public List<EstablishmentDTO> getAll() {
        return establishmentMapper.toDTO(establishmentRepository.findAll());
    }

    public EstablishmentDTO getById(int id) {
        return establishmentMapper.toDTO(establishmentRepository.getReferenceById(id));
    }

    public void delete(int id) {
        establishmentRepository.deleteById(id);
    }
}
