package com.el_economico.api.model.DTO.POST;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Data
public class CredencialesLogin {
    private String usuario;
    private String password;
    private Boolean client;
}
