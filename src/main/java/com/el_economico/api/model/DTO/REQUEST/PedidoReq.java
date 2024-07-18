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
    private String cliente;
    private float total;
    private int Estado;
}
