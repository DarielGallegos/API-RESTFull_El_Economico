package com.el_economico.api.model.DTO.POST;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AlmacenPOST {
    private int idProducto;
    private int cantidad;
    private String creadoPor;
    private String modificadoPor;
    private int estado;
}
