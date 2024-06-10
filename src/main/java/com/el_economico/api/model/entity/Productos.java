package com.el_economico.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Productos {
    @Id
    @Column(name = "id", nullable = false)
    private int ID;

    @Column(name = "producto", length = 150, nullable = false)
    private String nombre;

    @Column(name = "cod_producto", length = 150, nullable = false, unique = true)
    private String codProducto;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_categoria")
    @JsonBackReference
    private Categoria_Productos categoria;

    @Column(name = "marca", length = 150, nullable = false)
    private String marca;

    @Lob
    @Column(name = "foto", nullable = false, columnDefinition = "LongBlob")
    private byte[] foto;

    @Column(name = "precio", nullable = false)
    private float precio;

    @Column(name = "stock_min", nullable = false)
    private int stockMin;

    @Column(name = "stock_max", nullable = false)
    private int stockMax;

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

    //FOREIGN KEYS
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_producto")
    @JsonManagedReference
    private List<Almacen> almacenList;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_producto")
    @JsonManagedReference
    private List<Pedidos> pedidosList;
}
