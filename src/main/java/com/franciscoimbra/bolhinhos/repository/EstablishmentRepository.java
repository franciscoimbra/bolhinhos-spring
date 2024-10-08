package com.franciscoimbra.bolhinhos.repository;

import com.franciscoimbra.bolhinhos.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {}
