package com.el_economico.api.model.mapper;

import com.el_economico.api.model.DTO.POST.Rol;
import com.el_economico.api.model.entity.Roles;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolMapper {
    public List<Rol> toRol(List<Roles> rol) {
        return rol.stream().map(this::toRol).toList();
    }

    public Rol toRol(Roles rol) {
        return Rol.builder()
                .nombre(rol.getNombre())
                .creadoPor(rol.getCreado_por())
                .modificadoPor(rol.getModificado_por())
                .estado(rol.getEstado())
                .build();
    }
}
