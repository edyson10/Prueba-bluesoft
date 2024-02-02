package com.prueba.pruebabluesotf.Services;

import com.prueba.pruebabluesotf.Entity.Cuenta;

import java.util.Optional;

public interface CuentaService {

    void crearCuenta(Cuenta cuenta);

    Optional<Cuenta> buscarCuenta(String numeroCuenta);
}
