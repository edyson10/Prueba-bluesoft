package com.prueba.pruebabluesotf.Controller;

import com.prueba.pruebabluesotf.Exceptions.Mensaje;
import com.prueba.pruebabluesotf.Services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping(path = "/consignar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consignar(@RequestBody String numeroCuenta, @RequestBody double valor) {
        transaccionService.realizarConsignacion(numeroCuenta, valor);
        return new ResponseEntity(new Mensaje("Se realizó la consignación con éxito."), HttpStatus.OK);
    }

    @PostMapping(path = "/retirar")
    public ResponseEntity retirar(@RequestBody String numeroCuenta, @RequestBody double valor) {
        transaccionService.realizarRetiro(numeroCuenta, valor);
        return new ResponseEntity(new Mensaje("Se realizó el retiro con éxito."), HttpStatus.OK);
    }
}
