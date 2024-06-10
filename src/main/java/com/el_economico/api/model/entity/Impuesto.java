package com.el_economico.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "impuestos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Impuesto {
    @Id
    @Column(name = "id", nullable = false)
    private int ID;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "impuesto", nullable = false)
    private float impuesto;

    @Column(name="creado_por", nullable = false, length = 150, updatable = false)
    private String creado_por;

    @Column(name = "modificado_por", length = 150)
    private String modificado_por;

    @Column(name="creado_en", nullable = false, updatable = false)
    private Timestamp creado_en;

    @Column(name="modificado_en")
    private Timestamp modificado_en;

    @Column(name = "estado", length = 1)
    private int estado;
    //Se puede contemplar la referencia cíclica mas adelante, mientras tando se omite.
}
