package com.el_economico.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Clientes {
    @Id
    @Column(name="id")
    private int ID;

    @Column(name = "nombres", length = 150, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 150, nullable = false)
    private String apellidos;

    @Column(name = "fecha_nac", nullable = false, columnDefinition = "DATE")
    private Date fecheNacimiento;

    @Column(name = "genero", length = 1, nullable = false)
    private char genero;

    @Column(name = "correo", length = 150, nullable = false)
    private String correo;

    @Column(name = "telefono", length = 150, nullable = false)
    private String telefono;

    @Lob
    @Column(name = "foto", nullable = false, columnDefinition = "LongBlob")
    private byte[] foto;

    @Column(name = "usuario", length = 150, nullable = false, unique = true)
    private String usuario;

    @Column(name = "passwd", length = 150, nullable = false)
    private String password;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_rol")
    @JsonBackReference
    private Roles rol;

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
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_cliente")
    @JsonManagedReference
    private List<Pedidos> pedidosList;
}