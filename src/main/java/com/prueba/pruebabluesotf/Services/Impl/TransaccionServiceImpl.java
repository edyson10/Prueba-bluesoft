package com.prueba.pruebabluesotf.Services.Impl;

import com.prueba.pruebabluesotf.Entity.Cuenta;
import com.prueba.pruebabluesotf.Entity.Transaccion;
import com.prueba.pruebabluesotf.Entity.cuentaTransaccion;
import com.prueba.pruebabluesotf.Exceptions.ResourceNotFoundException;
import com.prueba.pruebabluesotf.Repository.CuentaRepository;
import com.prueba.pruebabluesotf.Repository.CuentraTransaccionRepository;
import com.prueba.pruebabluesotf.Repository.TransaccionRepository;
import com.prueba.pruebabluesotf.Services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentraTransaccionRepository cuentraTransaccionRepository;

    @Override
    public void realizarConsignacion(String numeroCuenta, double valor) {

        Optional<Cuenta> cuenta = cuentaRepository.findCuentaByNumeroCuenta(numeroCuenta);

        if (cuenta.isEmpty()) {
            throw new ResourceNotFoundException("No existe ese número de cuenta");
        } else {
            Transaccion transaccion = new Transaccion();
            transaccion.setFechaTransaccion(LocalDate.now());
            transaccion.setTipoTransaccion("Consignación");
            transaccion.setValorTransaccion(valor);
            transaccion.setCiudad("Cúcuta");
            transaccionRepository.save(transaccion);

            cuentaTransaccion cuentaTrans = new cuentaTransaccion();
            cuentaTrans.setCuenta(cuenta.get().getId());

            Transaccion ultimoRegistro = transaccionRepository.ultimoRegistro();
            cuentaTrans.setTransaccion(ultimoRegistro.getId());

            cuentraTransaccionRepository.save(cuentaTrans);

            double nuevoSaldo = cuenta.get().getSaldo() + valor;
            cuenta.get().setSaldo(nuevoSaldo);
        }
    }

    @Override
    public void realizarRetiro(String numeroCuenta, double valor) {

        Optional<Cuenta> cuenta = cuentaRepository.findCuentaByNumeroCuenta(numeroCuenta);

        if (cuenta.isEmpty()) {
            throw new ResourceNotFoundException("No existe ese número de cuenta");
        } else {
            if (cuenta.get().getSaldo() < 0 && cuenta.get().getSaldo() < valor) {
                throw new ResourceNotFoundException("No se puede hacer el retiro, su saldo es menor al solicitado.");
            } else {
                Transaccion transaccion = new Transaccion();
                transaccion.setFechaTransaccion(LocalDate.now());
                transaccion.setTipoTransaccion("Retiro");
                transaccion.setValorTransaccion(valor);
                transaccion.setCiudad("Cúcuta");
                transaccionRepository.save(transaccion);

                cuentaTransaccion cuentaTrans = new cuentaTransaccion();
                cuentaTrans.setCuenta(cuenta.get().getId());

                Transaccion ultimoRegistro = transaccionRepository.ultimoRegistro();
                cuentaTrans.setTransaccion(ultimoRegistro.getId());

                cuentraTransaccionRepository.save(cuentaTrans);

                double nuevoSaldo = cuenta.get().getSaldo() - valor;
                cuenta.get().setSaldo(nuevoSaldo);
            }
        }
    }
}
