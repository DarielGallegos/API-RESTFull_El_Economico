package com.el_economico.api.service.impl;

import com.el_economico.api.client.ClientIntern;
import com.el_economico.api.model.DTO.POST.PedidoPOST;
import com.el_economico.api.model.DTO.REQUEST.ImpuestoReq;
import com.el_economico.api.model.DTO.REQUEST.PedidoReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.PedidoReqMapper;
import com.el_economico.api.repository.PedidosRepository;
import com.el_economico.api.service.PedidosService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class PedidosServiceImpl implements PedidosService {

    private final ClientIntern client;
    private final PedidoReqMapper mapper;
    private final PedidosRepository repository;

    public PedidosServiceImpl(ClientIntern client, @Lazy PedidoReqMapper mapper, @Lazy PedidosRepository repository){
        this.client = client;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<PedidoReq> pedidos = mapper.toPedidoReq(this.repository.getAll());
        List<String> msg = List.of("Registros encontrados");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, pedidos));
    }

    @Override
    public ResponseEntity<ApiResponse> insertPedido(PedidoPOST e) {
        ApiResponse response = client.get("/impuestos/");
        List<ImpuestoReq> list = (List<ImpuestoReq>) response.getData().get("content");
        int id = parseInt(response.getData().get("content").toString().replace("[", "").replace("]", ""));
        this.repository.pedidosInsert(e.getIdUsuario(), e.getIdCliente(), e.getIdProducto(), e.getDestino(), e.getCantidad(), e.getMonto(), id, e.getSubtotal(), e.getEnvio(), e.getTotal(), e.getEstadoPedido(), e.getCreadoPor(), e.getEstado());
        List<String> msg = List.of("Registro no insertado");
        if(this.repository.existsById(id)){
            msg.set(0, "Registro insertado");
            return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.CREATED, msg, null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.NOT_ACCEPTABLE, msg, null));
    }
}
