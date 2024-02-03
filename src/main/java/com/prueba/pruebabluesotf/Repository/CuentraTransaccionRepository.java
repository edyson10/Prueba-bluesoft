package com.prueba.pruebabluesotf.Repository;

import com.prueba.pruebabluesotf.Entity.cuentaTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentraTransaccionRepository extends JpaRepository<cuentaTransaccion, Integer> {
}
