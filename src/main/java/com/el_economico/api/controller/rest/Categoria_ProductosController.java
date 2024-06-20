package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.Categoria_ProductosPOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.Categoria_ProductosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Categoria_Productos")
public class Categoria_ProductosController {
    @Autowired
    private Categoria_ProductosServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertCategoria(@RequestBody Categoria_ProductosPOST e){
        return this.service.insertCategoria(e);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> putCategoria(@PathVariable("id") int id, @RequestBody Categoria_ProductosPOST e){
        return this.service.putCategoria(e,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> changeStatus( @PathVariable("id") int id,@RequestBody Categoria_ProductosPOST e){
        return this.service.changeStatus(e,id);
    }
}
