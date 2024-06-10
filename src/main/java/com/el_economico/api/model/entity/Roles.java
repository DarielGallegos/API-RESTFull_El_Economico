package com.el_economico.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
//@JsonIgnoreProperties("hibernateLazyInitializer")
public class Roles {
    @Id
    @Column(name="id")
    private int ID;

    @Column(name="nombre", unique = true, nullable = false, length = 150)
    private String nombre;

    @Column(name="creado_por", nullable = false, length = 100, updatable = false)
    private String creado_por;

    @Column(name="modificado_por", length = 100)
    private String modificado_por;

    @Column(name="creado_en", length = 0, updatable = false)
    private Timestamp creado_en;

    @Column(name="modificado_en", nullable = false, length = 0)
    private Timestamp modificado_en;

    @Column(name="estado", length = 1)
    private int estado;


    //Foreing Key
    //Relacion con usuarios
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_rol")
    @JsonManagedReference
    private List<Usuario> usuarios;

    //Relacion con clientes
    @OneToMany
    @JoinColumn(name="id_rol")
    @JsonManagedReference
    private List<Clientes> clientes;
}
