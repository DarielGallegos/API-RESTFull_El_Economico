package com.el_economico.api.controller.rest;

import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.PedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/repartidores")
public class RepartidoresController {
    @Autowired
    private PedidosServiceImpl service;

    @GetMapping("/unsigned")
    public ResponseEntity<ApiResponse> getPedidosUnsigned(){
        return this.service.getPedidosUnsigned();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getAllPedidoForRepartidor(@PathVariable("id") int idUsuario){
        return this.service.getAllPedidoForRepartidor(idUsuario);
    }

    @GetMapping("/cabecera/{pedidoNumero}")
    public ResponseEntity<ApiResponse> getCabeceraPedido(@PathVariable("pedidoNumero") int pedidoNumero){
        return this.service.getCabeceraPedido(pedidoNumero);
    }
}
