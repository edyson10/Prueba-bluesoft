package com.prueba.pruebabluesotf.Services.Impl;

import com.prueba.pruebabluesotf.Entity.Cuenta;
import com.prueba.pruebabluesotf.Repository.CuentaRepository;
import com.prueba.pruebabluesotf.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void crearCuenta(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public Optional<Cuenta> buscarCuenta(String numeroCuenta) {
        return cuentaRepository.findCuentaByNumeroCuenta(numeroCuenta);
    }
}
