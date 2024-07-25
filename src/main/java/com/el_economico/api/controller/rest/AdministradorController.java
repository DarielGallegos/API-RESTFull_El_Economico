package com.el_economico.api.controller.rest;

import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.PedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/administrador")
public class AdministradorController {
    @Autowired
    private PedidosServiceImpl service;

    @GetMapping("/pedidosEntregados")
    public ResponseEntity<ApiResponse> getPedidosEntregados(){
        return this.service.getPedidosEntregados();
    }

    @GetMapping("/pedidosPendientes")
    public ResponseEntity<ApiResponse> getPedidosPendientes(){
        return this.service.getPedidosPendientes();
    }
}
