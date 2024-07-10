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
@Table(name="usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Usuario {
    @Id
    @Column(name="id")
    private int ID;

    @Column(name = "nombres", nullable = false, length = 150, unique = true)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 150, unique = true)
    private String dni;

    @Column(name = "fecha_nac", nullable = false, columnDefinition = "DATE")
    private Date fecha_nac;

    @Column(name = "genero", nullable = false, length = 1)
    private char genero;

    @Column(name = "telefono", nullable = false, length = 150)
    private String telefono;

    @Column(name = "correo", nullable = false, length = 150)
    private String correo;

    @Lob
    @Column(name = "foto", nullable = false, columnDefinition = "LongBlob")
    private String foto;

    @Column(name = "usuario", nullable = false, length = 150, unique = true)
    private String usuario;

    @Column(name = "passwd", nullable = false, length = 150)
    private String password;

    @ManyToOne(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            targetEntity = Roles.class
    )
    @JoinColumn(name = "id_rol")
    @JsonBackReference
    private Roles rol;

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

    //FOREIGN KEYS
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference
    private List<Pedidos> pedidosList;
}
