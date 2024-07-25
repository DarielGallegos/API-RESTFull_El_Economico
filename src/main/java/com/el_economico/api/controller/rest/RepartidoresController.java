package com.el_economico.api.controller.rest;

import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.PedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{numPedido}")
    public ResponseEntity<ApiResponse> pedidosChangeUser(@PathVariable("numPedido") int numPedido, @RequestParam("idUsuario") int idUsuario){
        return this.service.pedidosChangeUser(numPedido, idUsuario);
    }

    @PutMapping("/estado/{numPedido}")
    public ResponseEntity<ApiResponse> pedidosChangeState(@PathVariable("numPedido") int numPedido){
        return this.service.pedidosChangeState(numPedido);
    }
}
