package com.prueba.pruebabluesotf.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "documento_nit")
    private String documentoNit;

    @Column(name = "persona_juridica")
    private String personaJuridica;

    private String telefono;
}
