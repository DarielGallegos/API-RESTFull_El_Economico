package com.el_economico.api.model.DTO.POST;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolPOST {
    private String nombre;
    private String creadoPor;
    private String modificadoPor;
    private int estado;
}
