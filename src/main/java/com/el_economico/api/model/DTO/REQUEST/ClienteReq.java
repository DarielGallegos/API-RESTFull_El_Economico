package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClienteReq {

    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String foto;
    private String usuario;
    private String fechaNacimiento;
    private Character genero;
}
