package com.el_economico.api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.el_economico.api.service.impl.PedidosServiceImpl;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidosController<T> {
    @Autowired
    private PedidosServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<T> getAll(){
        return this.service.getAll();
    }

}
