package com.el_economico.api.model.DTO.POST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImpuestoPOST {
    private String nombre;
    private float impuesto;
    private String creadoPor;
    private String modificadoPor;
    private int estado;
}
