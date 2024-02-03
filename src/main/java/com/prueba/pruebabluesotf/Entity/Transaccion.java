package com.prueba.pruebabluesotf.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "transaccion")
@Data
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "valor_transaccion")
    private double valorTransaccion;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    @Column(name = "fecha_transaccion")
    private LocalDate fechaTransaccion;

    private String ciudad;
}
