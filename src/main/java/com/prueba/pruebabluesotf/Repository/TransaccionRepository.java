package com.prueba.pruebabluesotf.Repository;

import com.prueba.pruebabluesotf.Entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

    @Query(
            value = "SELECT * FROM transaccion t ORDER BY id DESC LIMIT 1",
            nativeQuery = true)
    Transaccion ultimoRegistro();
}
