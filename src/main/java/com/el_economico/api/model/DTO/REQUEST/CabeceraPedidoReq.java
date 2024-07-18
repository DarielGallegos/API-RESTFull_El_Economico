package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter@Getter@Builder@AllArgsConstructor@NoArgsConstructor
public class CabeceraPedidoReq {
    private int pedido_numero;
    private String usuario;
    private String cliente;
    private float total;
    private String estado_pedido;
}
