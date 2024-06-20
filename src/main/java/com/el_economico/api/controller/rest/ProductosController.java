package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.ProductosPOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.ProductosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductosController {
    @Autowired
    private ProductosServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertProductos(@RequestBody ProductosPOST e){
        return this.service.insertProductos(e);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> putProductos(@RequestBody ProductosPOST e, @PathVariable("id") int id){
        return this.service.putProductos(e, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> changeStatus(@RequestBody ProductosPOST e, @PathVariable("id") int id){
        return this.service.changeStatus(e, id);
    }
}
