package com.prueba.pruebabluesotf.Services;

public interface TransaccionService {

    void realizarConsignacion(String numeroCuenta, double valor);

    void realizarRetiro(String numeroCuenta, double valor);
}
