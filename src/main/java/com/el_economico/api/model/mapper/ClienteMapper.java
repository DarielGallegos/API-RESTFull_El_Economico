package com.el_economico.api.model.mapper;

import com.el_economico.api.model.DTO.REQUEST.ClienteReq;
import com.el_economico.api.model.entity.Clientes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {
    public List<ClienteReq> toClientesReq(List<Clientes> list) {
        return list.stream().map(this::toClientesReq).toList();
    }

    private ClienteReq toClientesReq(Clientes e) {
        return ClienteReq.builder()
                .id(e.getID())
                .nombres(e.getNombre())
                .apellidos(e.getApellidos())
                .correo(e.getCorreo())
                .telefono(e.getTelefono())
                .foto(e.getFoto())
                .usuario(e.getUsuario())
                .build();
    }
}
