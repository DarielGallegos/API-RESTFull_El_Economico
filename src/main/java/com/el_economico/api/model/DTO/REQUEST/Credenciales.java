package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Credenciales {
    private int id;
    private String usuario;
    private String nombre;
    private String telefono;
    private String Rol;
    private String correo;
    private Boolean empleado;
}
