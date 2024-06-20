package com.el_economico.api.model.mapper;


import com.el_economico.api.model.DTO.REQUEST.Categoria_ProductosReq;
import com.el_economico.api.model.entity.Categoria_Productos;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class Categoria_ProductosMapper {
    public List<Categoria_ProductosReq> toCategoria_ProductosReq(List<Categoria_Productos>list){
        return list.stream().map(this::toCategoria_ProductosReq).toList();
    }
    private Categoria_ProductosReq toCategoria_ProductosReq(Categoria_Productos e){
        return Categoria_ProductosReq.builder()
               .id(e.getID())
               .nombre(e.getNombre())
               .build();
    }
}
