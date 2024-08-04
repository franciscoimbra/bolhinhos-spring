package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.dto.ClientUserDTO;
import com.franciscoimbra.bolhinhos.mapper.ClientUserMapper;
import com.franciscoimbra.bolhinhos.model.ClientUser;
import com.franciscoimbra.bolhinhos.repository.ClientUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUserService {

    @Autowired
    private ClientUserRepository clientUserRepository;

    @Autowired
    private ClientUserMapper clientUserMapper;

    public ClientUserDTO save(ClientUserDTO clientUserdto) {
        return clientUserMapper.toClientUserDTO(clientUserRepository.save(clientUserMapper.toClientUser(clientUserdto)));
    }

    public ClientUserDTO findById(int id) {
        return clientUserMapper.toClientUserDTO(clientUserRepository.getReferenceById(id));
    }

    public List<ClientUserDTO> findAll() {
        return clientUserMapper.toClientUserDTO(clientUserRepository.findAll());
    }

    public void delete(int id) {
        clientUserRepository.deleteById(id);
    }
}
