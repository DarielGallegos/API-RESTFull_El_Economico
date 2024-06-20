package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

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
    private byte[] foto;
    private String usuario;

}
