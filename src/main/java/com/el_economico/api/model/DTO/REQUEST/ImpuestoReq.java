package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImpuestoReq {
    private int ID;
    private String nombre;
    private float impuesto;
}
