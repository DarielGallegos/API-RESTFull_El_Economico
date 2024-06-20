package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.AlmacenPOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.AlmacenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertAlmacen(@RequestBody AlmacenPOST e){
        return this.service.insertAlmacen(e);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> putAlmacen(@RequestBody AlmacenPOST e, @PathVariable("id") int id){
        return this.service.putAlmacen(e, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> changeStatus(@RequestBody AlmacenPOST e, @PathVariable("id") int id){
        return this.service.changeStatus(e, id);
    }

}
