package com.el_economico.api.model.DTO.POST;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductosPOST {
    private String producto;
    private String cod_producto;
    private int id_categoria;
    private String marca;
    private String foto;
    private float precio;
    private String descripcion;
    private int stock_min;
    private int stock_max;
    private String creado_por;
    private String modificado_por;
    private int estado;
}
