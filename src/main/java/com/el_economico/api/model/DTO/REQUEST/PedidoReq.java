package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoReq {
    private int idFactura;
    private int idUsuario;
    private int idCliente;
    private int idProducto;
    private float monto;
}
