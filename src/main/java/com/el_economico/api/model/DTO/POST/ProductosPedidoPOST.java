package com.el_economico.api.model.DTO.POST;

import lombok.*;

@Getter
@Setter
public class ProductosPedidoPOST {
    private int idProducto;
    private int cantidad;
    private float monto;
}
