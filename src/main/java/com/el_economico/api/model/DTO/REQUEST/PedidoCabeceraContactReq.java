package com.el_economico.api.model.DTO.REQUEST;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoCabeceraContactReq {
    private int pedidoNumero;
    private String Cliente;
    private String telefono;
    private String Ubicacion;
    private String correo;
    private float total;
}
