package com.prueba.pruebabluesotf.Controller;

import com.prueba.pruebabluesotf.Exceptions.Mensaje;
import com.prueba.pruebabluesotf.Entity.Cuenta;
import com.prueba.pruebabluesotf.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping(path = "/crear-cuenta")
    public ResponseEntity save(@RequestBody Cuenta cuenta) {
        cuentaService.crearCuenta(cuenta);
        return new ResponseEntity(new Mensaje("Se creo la cuenta correctamente."), HttpStatus.OK);
    }

    @GetMapping(path = "/consultar-cuenta/{numeroCuenta}")
    public ResponseEntity<Cuenta> findById(@PathVariable("numeroCuenta") String numeroCuenta) {

        Optional<Cuenta> cuenta = cuentaService.buscarCuenta(numeroCuenta);

        if (cuenta.isEmpty()) {
            return new ResponseEntity(new Mensaje("Esa cuenta no existe."), HttpStatus.OK);
        } else {
            return new ResponseEntity(cuenta.get(), HttpStatus.OK);
        }
    }
}
