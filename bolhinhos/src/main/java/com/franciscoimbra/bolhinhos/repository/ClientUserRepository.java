package com.franciscoimbra.bolhinhos.repository;

import com.franciscoimbra.bolhinhos.model.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {
}
