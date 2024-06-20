package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioReq {

    private int id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private byte[] foto;
    private String usuario;

}
