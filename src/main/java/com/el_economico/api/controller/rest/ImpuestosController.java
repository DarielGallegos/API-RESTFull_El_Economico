package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.ImpuestoPOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.ImpuestoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/impuestos")
public class ImpuestosController {
    @Autowired
    private ImpuestoServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertImpuesto(@RequestBody ImpuestoPOST e){
        return this.service.insertImpuesto(e);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> putImpuesto(@RequestBody ImpuestoPOST e, @PathVariable("id") int id){
        return this.service.putImpuesto(e, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> changeStatus(@RequestBody ImpuestoPOST e, @PathVariable("id") int id){
        return this.service.changeStatus(e, id);
    }
}
