package com.el_economico.api.model.mapper;

import com.el_economico.api.model.DTO.REQUEST.PedidoReq;
import com.el_economico.api.model.entity.Pedidos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoReqMapper {
    public List<PedidoReq> toPedidoReq(List<Pedidos> list){

        return list.stream().map(this::toPedidoReq).toList();
    }

    public PedidoReq toPedidoReq(Pedidos e){
        return PedidoReq.builder()
                .idFactura(e.getID())
                .cliente(e.getCliente().getNombre() + " " + e.getCliente().getApellidos())
                .total(e.getTotal())
                .Estado(e.getEstado())
                .build();
    }
}
