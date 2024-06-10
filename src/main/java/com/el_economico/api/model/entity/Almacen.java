package com.el_economico.api.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "almacen")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Almacen {
    @Id
    @Column(name = "id", nullable = false)
    private int ID;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonManagedReference
    private Productos producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

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
}
