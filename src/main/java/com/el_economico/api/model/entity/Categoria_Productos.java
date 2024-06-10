package com.el_economico.api.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="categoria_productos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Categoria_Productos {
    @Id
    @Column(name="id")
    private int ID;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name="creado_por", nullable = false, length = 150, updatable = false)
    private String creado_por;

    @Column(name = "modificado_por", length = 150)
    private String modificado_por;

    @Column(name="creado_en", updatable = false)
    private Timestamp creado_en;

    @Column(name="modificado_en")
    private Timestamp modificado_en;

    @Column(name = "estado", length = 1)
    private int estado;

    //Foreign Key
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_categoria")
    @JsonManagedReference
    private List<Productos> productos;
}
