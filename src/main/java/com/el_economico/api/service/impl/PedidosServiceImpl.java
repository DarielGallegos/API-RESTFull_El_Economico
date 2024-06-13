package com.el_economico.api.service.impl;

import com.el_economico.api.client.ClientIntern;
import com.el_economico.api.model.DTO.POST.Rol;
import com.el_economico.api.model.DTO.REQUEST.PedidoReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.PedidoReqMapper;
import com.el_economico.api.model.mapper.RolMapper;
import com.el_economico.api.repository.PedidosRepository;
import com.el_economico.api.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceImpl<T> implements PedidosService {

    private final ClientIntern client;
    private final PedidoReqMapper mapper;
    private final PedidosRepository repository;

    public PedidosServiceImpl(ClientIntern client, @Lazy PedidoReqMapper mapper, @Lazy PedidosRepository repository){
        this.client = client;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ResponseEntity getAll() {
        List<PedidoReq> pedidos = mapper.toPedidoReq(this.repository.getAll());
        RolMapper RolMapper = new RolMapper();
        ApiResponse roles = client.get("/roles/");
        List<T> list = (List<T>) List.of(pedidos, roles);
        List<String> msg = List.of("Registros encontrados");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, list));
    }
}
