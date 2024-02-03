package com.prueba.pruebabluesotf.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cuenta_transaccion")
@Data
public class cuentaTransaccion {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cuenta;

    private int transaccion;
}
