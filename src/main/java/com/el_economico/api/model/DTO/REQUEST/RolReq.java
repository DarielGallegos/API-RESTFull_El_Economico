package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolReq {
    private String nombre;
    private int estado;
}
