package com.el_economico.api.model.DTO.POST;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoPOST {

    private int idUsuario;
    private int idCliente;
    private int idProducto;
    private String destino;
    private int cantidad;
    private float monto;
    private float subtotal;
    private float envio;
    private float total;
    private String estadoPedido;
    private String creadoPor;
    private int estado;
    private ImpuestoPOST impuesto;
}
