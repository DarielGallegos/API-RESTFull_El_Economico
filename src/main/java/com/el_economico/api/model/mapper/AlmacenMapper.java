package com.el_economico.api.model.mapper;

import com.el_economico.api.model.DTO.REQUEST.AlmacenReq;
import com.el_economico.api.model.entity.Almacen;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class AlmacenMapper {
    public List<AlmacenReq> toAlmacenReq(List<Almacen> list) {
       return list.stream().map(this::toAlmacenReq).toList();
    }

    private AlmacenReq toAlmacenReq(Almacen e) {
        return AlmacenReq.builder()
                .ID(e.getID())
                .id_producto(e.getProducto().getID())
                .cantidad((e.getCantidad()))
                .build();
    }
}
