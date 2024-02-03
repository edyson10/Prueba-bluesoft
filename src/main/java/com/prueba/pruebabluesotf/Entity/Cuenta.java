package com.prueba.pruebabluesotf.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cuenta")
@Data
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_cuenta")
    private int tipoCuenta;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "cliente")
    private int cliente;

    @Column(name = "saldo")
    private double saldo;

}
