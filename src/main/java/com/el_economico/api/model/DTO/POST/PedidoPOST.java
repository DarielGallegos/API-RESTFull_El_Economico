package com.el_economico.api.model.DTO.POST;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoPOST {

    private int idUsuario;
    private int idCliente;
    private String destino;
    private List<ProductosPedidoPOST> productos;
    private int impuesto;
    private float subtotal;
    private float envio;
    private float total;
    private String estadoPedido;
    private String creadoPor;
    private int estado;
}
