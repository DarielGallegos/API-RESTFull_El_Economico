package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductosReq {
    private int ID;
    private String producto;
    private String cod_producto;
    private int id_categoria;
    private String marca;
    private String foto;
    private String descripcion;
    private float precio;
    private int stock_min;
    private int stock_max;

}
