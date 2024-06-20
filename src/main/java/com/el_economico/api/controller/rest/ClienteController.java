package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.ClientePOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Clientes")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertCliente(@RequestBody ClientePOST e){
        return this.service.insertCliente(e);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> putCliente(@PathVariable("id") int id, @RequestBody ClientePOST e){
        return this.service.putCliente(e, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> changeStatus(@PathVariable("id") int id, @RequestBody ClientePOST e){
        return this.service.changeStatus(e, id);
    }


}
