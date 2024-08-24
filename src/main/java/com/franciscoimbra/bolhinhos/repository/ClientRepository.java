package com.franciscoimbra.bolhinhos.repository;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByPhoneContainingOrNifContaining(String phone, String nif);

}
