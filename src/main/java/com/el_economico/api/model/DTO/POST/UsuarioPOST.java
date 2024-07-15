package com.el_economico.api.model.DTO.POST;

import lombok.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioPOST {
    private int    ID;
    private String nombres;
    private String apellidos;
    private String dni;
    private Date   fecha_nac;
    private char   genero;
    private String correo;
    private String telefono;
    private String foto;
    private String usuario;
    private String passwd;
    private  int   id_rol;
    private String creado_por;
    private String modificado_por;
    private int    estado;
}
