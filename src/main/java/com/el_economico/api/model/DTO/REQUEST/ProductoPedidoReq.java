package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Getter@Setter@Builder@AllArgsConstructor@NoArgsConstructor
public class ProductoPedidoReq {
    private String NombreProducto;
    private float Precio;
    private int Cantidad;
    private float Monto;
    private String Imagen;
}
