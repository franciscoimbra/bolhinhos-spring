package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.mapper.AddressMapper;
import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    public Address save(AddressDTO addressDTO) {
        return addressRepository.save(addressMapper.addressDTOToAddress(addressDTO));
    }
    public List<AddressDTO> getAll() {
        System.out.println("teste1"+addressRepository.findAll());
        return addressMapper.addressesToAddressDTOs(addressRepository.findAll());
    }

    public Address findById(Long id) {
        return addressRepository.getReferenceById(id);
    }


    public void delete(Address address) {
        addressRepository.delete(address);
    }

}
