package com.el_economico.api.model.mapper;

import com.el_economico.api.model.DTO.REQUEST.RolReq;
import com.el_economico.api.model.entity.Roles;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolMapper {
    public List<RolReq> toRol(List<Roles> rol) {
        return rol.stream().map(this::toRol).toList();
    }

    public RolReq toRol(Roles rol) {
        return RolReq.builder()
                .nombre(rol.getNombre())
                .estado(rol.getEstado())
                .build();
    }
}
