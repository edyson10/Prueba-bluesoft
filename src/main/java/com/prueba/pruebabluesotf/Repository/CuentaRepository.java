package com.prueba.pruebabluesotf.Repository;

import com.prueba.pruebabluesotf.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    Optional<Cuenta> findByCuenta(String numeroCuenta);
}
