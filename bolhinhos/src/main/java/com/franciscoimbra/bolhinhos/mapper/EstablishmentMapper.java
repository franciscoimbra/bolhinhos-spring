package com.franciscoimbra.bolhinhos.mapper;

import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.model.Establishment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {
    EstablishmentDTO toDTO(Establishment establishment);
    Establishment toEntity(EstablishmentDTO establishmentDTO);
    List<EstablishmentDTO> toDTO(List<Establishment> establishments);
    List<Establishment> toEntity(List<EstablishmentDTO> establishmentDTOs);
}
