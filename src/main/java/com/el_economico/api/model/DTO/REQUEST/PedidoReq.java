package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoReq {
    private int NumeroPedido;
    private String Cliente;
    private String Usuario;
    private String Destino;
    private int idUsuario;
    private List<ProductoPedidoReq> productos;
    private float Total;
    private String Estado;
}
