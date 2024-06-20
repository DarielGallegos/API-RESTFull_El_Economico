package com.el_economico.api.model.mapper;


import com.el_economico.api.model.DTO.REQUEST.UsuarioReq;
import com.el_economico.api.model.entity.Usuario;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsuarioMapper {
    public List<UsuarioReq> toUsuarioReq(List<Usuario> list) {
        return list.stream().map(this::toUsuarioReq).toList();
    }

    private UsuarioReq toUsuarioReq(Usuario e){
        return UsuarioReq.builder()
                .id(e.getID())
                .nombres(e.getNombre())
                .apellidos(e.getApellidos())
                .dni(e.getDni())
                .telefono(e.getTelefono())
                .correo(e.getCorreo())
                .foto(e.getFoto())
                .usuario(e.getUsuario())
                .build();
    }
}
