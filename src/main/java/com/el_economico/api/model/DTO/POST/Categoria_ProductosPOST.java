package com.el_economico.api.model.DTO.POST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Categoria_ProductosPOST {

    private int    ID;
    private String nombre;
    private String creado_por;
    private String modificado_por;
    private int    estado;

}
