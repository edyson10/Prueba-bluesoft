package com.prueba.pruebabluesotf.Repository;

import com.prueba.pruebabluesotf.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteReporitory extends JpaRepository<Cliente, Integer> {
}
