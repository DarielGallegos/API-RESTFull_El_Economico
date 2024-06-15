package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.PedidoPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.el_economico.api.service.impl.PedidosServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidosController {
    @Autowired
    private PedidosServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertPedido(@RequestBody PedidoPOST e){
        return this.service.insertPedido(e);
    }

}
