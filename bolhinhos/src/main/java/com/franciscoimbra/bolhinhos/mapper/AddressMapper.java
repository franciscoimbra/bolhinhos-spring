package com.franciscoimbra.bolhinhos.mapper;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address addressDTOToAddress(AddressDTO addressDTO);
    AddressDTO addressToAddressDTO(Address address);
    List<AddressDTO> addressesToAddressDTOs(List<Address> addresses);
    List<Address> addressesDTOsToAddresses(List<AddressDTO> addressDTOs);
}