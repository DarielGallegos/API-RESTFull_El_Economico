package com.el_economico.api.model.mapper;


import com.el_economico.api.model.DTO.REQUEST.ProductosReq;
import com.el_economico.api.model.entity.Productos;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component

public class ProductosMapper {
    public List<ProductosReq> toProductosReq(List<Productos> list){
        return list.stream().map(this::toProductosReq).toList();
    }

    private ProductosReq toProductosReq(Productos e){
        return ProductosReq.builder()
                .ID(e.getID())
                .producto(e.getNombre())
                .cod_producto(e.getCodProducto())
                .id_categoria(e.getCategoria().getID())
                .marca(e.getMarca())
                .foto(Arrays.toString(e.getFoto().toCharArray()))
                .precio(e.getPrecio())
                .stock_min(e.getStockMin())
                .stock_max(e.getStockMax())
                .build();
    }
}
