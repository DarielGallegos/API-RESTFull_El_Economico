package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlmacenReq {
    private int ID;
    private int id_producto;
    private int cantidad;
}
