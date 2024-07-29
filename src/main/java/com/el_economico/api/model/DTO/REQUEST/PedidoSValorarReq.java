package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter@Getter@Builder@AllArgsConstructor@NoArgsConstructor@Data
public class PedidoSValorarReq {
    private int pedidoNumero;
    private String Cliente;
    private String usuario;
    private float total;
    private String estado;
}
