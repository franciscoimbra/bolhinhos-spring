package com.franciscoimbra.bolhinhos.mapper;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientUserDTO;
import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.ClientUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientUserMapper {
    ClientUserDTO toClientUserDTO(ClientUser clientUser);
    ClientUser toClientUser(ClientUserDTO clientUserDTO);
    List<ClientUserDTO> toClientUserDTO(List<ClientUser> clientUsers);
    List<ClientUser> toClientUsers(List<ClientUserDTO> clientUserDTOs);
}
